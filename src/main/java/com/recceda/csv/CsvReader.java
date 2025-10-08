package com.recceda.csv;

import com.recceda.elements.User;

import java.util.List;

public interface CsvReader {
    List<User> read();
    int countRows();
}
