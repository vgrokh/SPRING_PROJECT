package com.vgrokh.springcrud.integration.twilio;


import com.vgrokh.springcrud.config.TwilioConfiguration;
import com.vgrokh.springcrud.twilio.TwilioInitializer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TwilioInitializer.class, TwilioConfiguration.class})
public class TwilioTest {


    @Autowired
    TwilioInitializer twilioInitializer;
    ByteArrayOutputStream outContent;

    @BeforeAll
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void ConnectionIsEstablished(){
        String expectedMessage = twilioInitializer.getTwilioWelcomeMessage();
        Assert.assertEquals(expectedMessage, outContent.toString().contains(expectedMessage));
    }
}
