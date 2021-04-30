package com.wf.masailhelper;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class BasicController {

    @RequestMapping("/helloworld")
    public String index() {
        return "As Salaamu Alaykum Wa Rahmatullah!";
    }

}