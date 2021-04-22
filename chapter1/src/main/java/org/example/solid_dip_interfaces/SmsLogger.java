package org.example.org.example.solid_dip_interfaces;

public class SmsLogger implements Logger {

    public void createLogEntry(String errorMessage) {
        SmsFactory.sendSms(errorMessage);
    }
}
