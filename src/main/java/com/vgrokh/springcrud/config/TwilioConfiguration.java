package com.vgrokh.springcrud.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@NoArgsConstructor
public class TwilioConfiguration {

    @Value("${twilio.ac}")
    private  String accountSid;
    @Value("${twilio.at}")
    private  String authToken;
    @Value("${twilio.tn}")
    private String trialNumber;
    @Value("${twilio.gp}")
    private String generatedPassword;
}
