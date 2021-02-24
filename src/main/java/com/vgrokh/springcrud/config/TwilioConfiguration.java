package com.vgrokh.springcrud.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@NoArgsConstructor
public class TwilioConfiguration {

    @Value("${twilio.account_sid}")
    private  String accountSid;
    @Value("${twilio.auth_token}")
    private  String authToken;
    @Value("${twilio.trial_number}")
    private String trialNumber;
    @Value("${twilio.generated_password}")
    private String generatedPassword;
}
