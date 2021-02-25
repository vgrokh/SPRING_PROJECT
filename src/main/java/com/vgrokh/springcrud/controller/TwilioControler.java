package com.vgrokh.springcrud.controller;

import com.vgrokh.springcrud.model.Role;
import com.vgrokh.springcrud.model.Status;
import com.vgrokh.springcrud.model.User;
import com.vgrokh.springcrud.repository.UserRepository;
import com.vgrokh.springcrud.twilio.SmsRequest;
import com.vgrokh.springcrud.twilio.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/registration")
public class TwilioControler {

    private final SmsService smsService;
    private final UserRepository userRepository;
    @Value("${twilio.gp}")
    private String generatedPassword;

    @Autowired
    public TwilioControler(SmsService smsService, UserRepository userRepository) {
        this.smsService = smsService;
        this.userRepository = userRepository;
    }


    @PostMapping
    public void sendSms(@RequestBody  SmsRequest smsRequest){
        String email = smsRequest.getEmail();
        String userName = smsRequest.getUserName();
        User userToRegister = new User(email, userName, generatedPassword, Role.USER, Status.ACTIVE);
       try {
           userRepository.save(userToRegister);
           smsService.sendSms(smsRequest);
       } catch (Exception e){
           e.printStackTrace();
       }
    }
}
