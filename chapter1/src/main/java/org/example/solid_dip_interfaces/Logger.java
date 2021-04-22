package org.example.org.example.solid_dip_interfaces;

import java.io.IOException;

public interface Logger {
    void createLogEntry(String errorMessage) throws IOException;
}
