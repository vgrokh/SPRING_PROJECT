package com.vgrokh.springcrud.twilio;

import com.twilio.Twilio;
import com.vgrokh.springcrud.config.TwilioConfiguration;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
@Data
public class TwilioInitializer {

    private final TwilioConfiguration twilioConfiguration;
    private final String twilioWelcomeMessage = "Twilio connection is created";

    @Autowired
    public TwilioInitializer(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
        System.out.println(twilioWelcomeMessage);
    }
}
