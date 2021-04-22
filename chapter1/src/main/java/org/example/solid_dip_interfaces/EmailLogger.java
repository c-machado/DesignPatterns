package org.example.org.example.solid_dip_interfaces;

public class EmailLogger implements Logger {

    public void createLogEntry(String errorMessage) {
        EmailFactory.sendEmail(errorMessage);
    }
}
