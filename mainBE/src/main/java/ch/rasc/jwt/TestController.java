package ch.rasc.jwt;

import ch.rasc.jwt.model.Message;
import ch.rasc.jwt.model.Result;
import ch.rasc.jwt.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@CrossOrigin
public class TestController {

  @GetMapping("/public")
  public String publicService() {
    return "This message is public";
  }

  @PostMapping("/register")
  public String registerService(@RequestBody User user) {

    RestTemplate restTemplate = new RestTemplate();
    String baseUrl = "http://localhost:8090/api/users/create/";
    URI uri = null;
    try {
      uri = new URI(baseUrl);
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    ResponseEntity<String> _result = restTemplate.postForEntity(uri, user, String.class);
    System.out.println(_result);
    return "successfully registered";
  }

  @PostMapping("/send")
  public String sendService(@RequestBody Message message) {

    RestTemplate restTemplate = new RestTemplate();
    String baseUrl = "http://localhost:8090/api/message/create/";
    URI uri = null;
    try {
      uri = new URI(baseUrl);
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    ResponseEntity<String> _result = restTemplate.postForEntity(uri, message, String.class);
    System.out.println(_result);
    return "successfully registered";
  }
}
