package br.com.felipedemorais.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class AppController {

    @ResponseBody
    @RequestMapping(value="/", method=GET)
    public String helloWorld() {
        return "Hello world!";
    }
}
