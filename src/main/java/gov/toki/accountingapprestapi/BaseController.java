package gov.toki.accountingapprestapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping
    public String BaseControllerTest(){
        return "Spring Boot Application => Fourth Test 16:40";
    }
}