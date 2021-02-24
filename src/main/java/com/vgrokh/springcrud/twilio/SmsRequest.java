package com.vgrokh.springcrud.twilio;

import lombok.Data;

@Data
public class SmsRequest {
    private final String userName;
    private final String phoneNumber;
    private final String email;
    private final String generatedPassword;
}
