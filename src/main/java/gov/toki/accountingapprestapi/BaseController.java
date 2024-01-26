package gov.toki.accountingapprestapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping
    public String BaseControllerTest(){
        return "Spring Boot Application =>Automatic Build 26 Jan 2024 16:47";
    }
}