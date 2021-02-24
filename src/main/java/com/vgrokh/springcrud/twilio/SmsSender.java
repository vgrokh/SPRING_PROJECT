package com.vgrokh.springcrud.twilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import com.vgrokh.springcrud.config.TwilioConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsSender implements SmsSendable {

    private final TwilioConfiguration twilioConfiguration;


    @Autowired
    public SmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        PhoneNumber from = new PhoneNumber(smsRequest.getPhoneNumber());
        PhoneNumber to = new PhoneNumber(twilioConfiguration.getTrialNumber());
        String email = smsRequest.getEmail();
        String userName = smsRequest.getUserName();
        String messageToSend = "Your registration is successful!" +
                                "UserName: " + userName +
                                " Email: " + email +
                                " Password: " + twilioConfiguration.getGeneratedPassword();
        MessageCreator creator = Message.creator(from, to, messageToSend);
        creator.create();
    }
}
