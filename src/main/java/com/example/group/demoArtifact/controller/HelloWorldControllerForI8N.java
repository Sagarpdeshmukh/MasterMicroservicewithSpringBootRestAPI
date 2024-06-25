package com.example.group.demoArtifact.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldControllerForI8N {
    private MessageSource messageSources;

   public HelloWorldControllerForI8N(MessageSource messageSource) {
        this.messageSources = messageSource;
    }


    @RequestMapping(path = "/helloi8n",method = RequestMethod.GET)
    public String Hello(){
        Locale locale = LocaleContextHolder.getLocale();
     return   messageSources.getMessage("good.morning.messagess",null,"Default meddages",locale);
      //  return "Hello from i8n";
    }
}
