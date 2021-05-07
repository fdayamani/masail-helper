package com.wf.masailhelper;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class BasicController {

    @RequestMapping("/helloworld")
    public String hello() {
        return "Hello Arif!";
    }

}