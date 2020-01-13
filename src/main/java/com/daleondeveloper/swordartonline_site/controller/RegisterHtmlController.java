package com.daleondeveloper.swordartonline_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping("/html")
public class RegisterHtmlController {

    @RequestMapping(value = "/Reg", method = RequestMethod.GET)
    public String mymethod(Locale locale, Model model){
        return "Registration";
    }
}
