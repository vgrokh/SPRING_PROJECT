package com.vgrokh.springcrud.controller;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {
    private String email;
    private String password;

}
