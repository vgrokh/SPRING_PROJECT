package com.vgrokh.springcrud.twilio;

public interface SmsSendable {
    void sendSms(SmsRequest smsRequest);
}
