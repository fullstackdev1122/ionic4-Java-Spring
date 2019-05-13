package com.javasampleapproach.springrest.mysql.controller;

import com.javasampleapproach.springrest.mysql.model.*;
import com.javasampleapproach.springrest.mysql.model.sub.Data;
import com.javasampleapproach.springrest.mysql.model.sub.Notification;
import com.javasampleapproach.springrest.mysql.model.sub.Price;
import com.javasampleapproach.springrest.mysql.model.sub.Visitors;
import com.javasampleapproach.springrest.mysql.repo.MessageRepository;
import com.javasampleapproach.springrest.mysql.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class NtController {
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    //////////////////////////// Notification /////////////////////////////////////
    @RequestMapping(value = "/users/create")
    public String postUser(@RequestBody User user) {

        List<User> list = userRepository.findByUseridAndDeviceid(user.getUserid(), user.getDeviceid());
        if (list.size() > 0) {
            System.out.println("Already Exist");
            return "Exist";
        }
        System.out.println("Created");

        User _user = userRepository.save(new User(user.getUserid(), user.getDeviceid()));
        return "success";
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
        System.out.println("Delete User with userID = " + id + "...");

        // Delete in user db
        userRepository.deleteByUserid(id);
        return new ResponseEntity<>("Role has been deleted!", HttpStatus.OK);
    }

    @GetMapping(value = "/users/userid/{userid}")
    public List<User> findByUserid(@PathVariable String userid) {

        System.out.println("Get deviceID = " + userid + "...");

        List<User> users = userRepository.findByUserid(userid);
        return users;
    }

    ////////////////////////  Message //////////////////////////////////
    @RequestMapping(value = "/message/create")
    public String postMessage(@RequestBody Message message) {

        System.out.println("Message received!");
        Message _message = messageRepository.save(new Message(message.getUserid(), message.getVisitorid(), message.getContent()));
        return "success";
    }

    ////////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/notify")
    public String notify(@RequestBody Result result) {
        System.out.println(result.user);

        FirebaseBody firebaseBody = null;

        Notification notification = new Notification("Role Management Support", "Your visiter, XY has arrived", "default", "FCM_PLUGIN_ACTIVITY", "fcm_push_icon");
        Visitors visitors = new Visitors("mQWLdQOn9K", result.getVisitor(), "koocka44@gmail.com", "XX company", "2019-04-30 12:15", "2019-05-30 12:15", "123456789", false );
        Price price = new Price("Lehel", "business@role.com", result.getMessage(), visitors);
        Data data = new Data("second", price);

        List<User> users = userRepository.findByUserid(result.getUser());
        for (int i = 0; i < users.size() ; i++)
        {
            String deviceid = users.get(i).getDeviceid();
            firebaseBody = new FirebaseBody(notification, data, deviceid, "high", "");
            System.out.println("----------------------");
            System.out.println(deviceid);
        }

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "key=AAAAvkLQUNg:APA91bELNzOrvKvXunXyg-MZ55pYtH6d_Z4bCxVGeOm4J9PYY19PqAEaD5SGWtGdsddjjh_z9qcd66ySRcIl8H7Txv2QeMF_Qg4vz7gRDzs4nVpWQ48FbQhuYHmHLHSZ336hBy98D-WW");
        HttpEntity<FirebaseBody> entity = new HttpEntity<FirebaseBody>(firebaseBody, headers);

        String baseUrl = "https://fcm.googleapis.com/fcm/send";

        URI uri = null;
        try {
            uri = new URI(baseUrl);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        ResponseEntity<String> _result = restTemplate.postForEntity(uri, entity, String.class);

        System.out.println(_result);

        return "success";
    }
}
