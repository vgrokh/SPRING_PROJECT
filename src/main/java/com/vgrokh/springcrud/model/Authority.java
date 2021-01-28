package com.vgrokh.springcrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
public enum  Authority {
    DEVELOPERS_WRITE("developers_write"),
    DEVELOPERS_READ("developers_read");

    private String Authority;

    public String getAuthority() {
        return Authority;
    }

    public void setAuthority(String authority) {
        Authority = authority;
    }
}
