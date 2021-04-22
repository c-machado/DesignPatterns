package org.example.org.example.solid_dip_interfaces;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileLogger implements Logger {

    public void createLogEntry(String error) throws IOException {
        Path path = Paths.get("/Users/machadoca/caro.txt");
        BufferedWriter writer = Files.newBufferedWriter(path);
        writer.write(error);
    }
}
