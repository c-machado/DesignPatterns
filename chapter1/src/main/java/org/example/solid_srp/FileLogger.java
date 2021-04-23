package org.example.solid_srp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileLogger {
    public void createLogEntry(String error) throws IOException {
        Path path = Paths.get("//copy caro");
        BufferedWriter writer = Files.newBufferedWriter(path);
        writer.write(error);
    }
}
