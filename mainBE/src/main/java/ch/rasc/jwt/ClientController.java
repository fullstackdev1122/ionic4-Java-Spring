package ch.rasc.jwt;

import ch.rasc.jwt.model.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Controller
public class ClientController {

    // inject via application.properties
    @Value("${index.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String index(Map<String, Object> model) {

        model.put("message", new Result("XX User", "YY visitor", "How are you"));
        return "index";
    }

    @RequestMapping("/submit")
    public String post(Map<String, Object> model) {

        RestTemplate restTemplate = new RestTemplate();

        String baseUrl = "http://localhost:8090/api/notify/";

        Result result = new Result("o", "visitor1", "Your visitor just arrived.");
        URI uri = null;
        try {
            uri = new URI(baseUrl);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        ResponseEntity<String> _result = restTemplate.postForEntity(uri, result, String.class);

        System.out.println(_result);

        model.put("message", new Result("User", "visitor", "Please wait"));
        return "index";
    }
}
