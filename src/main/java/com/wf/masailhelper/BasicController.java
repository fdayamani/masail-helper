package com.wf.masailhelper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @RequestMapping("/helloworld")
    public String hello() {
        return "Hello Arif!";
    }

}