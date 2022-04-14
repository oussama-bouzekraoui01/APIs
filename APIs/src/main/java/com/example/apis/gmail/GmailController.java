package com.example.apis.gmail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;


@RestController
@RequestMapping(path = "api/v1/gmail")
public class GmailController {

    private final GmailService gmailService;

    @Autowired
    public GmailController(GmailService gmailService) {
        this.gmailService = gmailService;
    }

    @PostMapping
    public void sendMail(@RequestBody GmailParam gmail) throws MessagingException {
        gmailService.sendMessage(gmail);
    }

}
