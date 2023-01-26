package com.stringcodeltd.studentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stringcodeltd.studentapp.service.InAppService;

@RestController
@RequestMapping("api/vi/messages")
public class InAppController {
    @Autowired
    private InAppService senderService;

    @PostMapping("/api/messages")
    String sendEmailMessage(){
        senderService.sendEmail("ryderflynn06@gmail.com", "subject of the mail sent", "this is the body of the email");
        return null;
    }
}
