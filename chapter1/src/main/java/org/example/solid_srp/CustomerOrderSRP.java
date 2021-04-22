package org.example.org.example.solid_srp;

import java.io.IOException;

public class CustomerOrderSRP {
    private final FileLogger _fileLogger = new FileLogger();

    public void create() throws IOException {
        try {
            //create purchases and save them in the DB
        }
        //log activity..//this class has too many responsibilities
        catch (Exception ex) {
            _fileLogger.createLogEntry(ex.getLocalizedMessage());
        }
    }
}