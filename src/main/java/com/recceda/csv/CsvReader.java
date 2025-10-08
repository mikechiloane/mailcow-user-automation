package com.recceda.csv;

import com.recceda.elements.User;

import java.io.IOException;
import java.util.List;

public interface CsvReader {
    List<User> read() throws IOException;
    int countRows() throws IOException;
}
