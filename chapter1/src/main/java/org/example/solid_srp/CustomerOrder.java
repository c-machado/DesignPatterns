package org.example.org.example.solid_srp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomerOrder {
    public void create() throws IOException {
        try {
            //create purchases and save them in the DB
        }
        //log activity..//this class has too many responsibilities
        catch (Exception ex) {
            Path path = Paths.get("caro copy");
            BufferedWriter writer = Files.newBufferedWriter(path);
            writer.write(ex.getLocalizedMessage());
        }
    }
}