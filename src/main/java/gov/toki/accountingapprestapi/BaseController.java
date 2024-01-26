package gov.toki.accountingapprestapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping
    public String BaseControllerTest(){
        return "Spring Boot Application => Third Test 16:32";
    }
}