package com.vgrokh.springcrud.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@NoArgsConstructor
public class TwilioConfiguration {

    String accountSid = System.getenv().get("ACCOUNT_SID");
    String authToken = System.getenv().get("AUTH_TOKEN");
    String trialNumber = System.getenv().get("PHONE_NUMBER");
    String generatedPassword = System.getenv().get("GENERATED_PASSWORD");
}
