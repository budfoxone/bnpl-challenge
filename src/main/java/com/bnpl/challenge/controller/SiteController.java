package com.bnpl.challenge.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class SiteController {

    @GetMapping("/")
    public String index(Model model) {
        return "forward:/index.html";
    }

}
