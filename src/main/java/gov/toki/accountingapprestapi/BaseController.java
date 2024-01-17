package gov.toki.accountingapprestapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping
    public String BaseControllerTest(){
        return "Its Run2";
    }

    @GetMapping("/test")
    public String TestController(){
        return "It's Run for Test Controller2";
    }
}