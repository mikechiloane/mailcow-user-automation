package com.recceda.csv;

import com.recceda.elements.User;

import java.io.File;
import java.util.List;

public class SimpleCsvReader implements CsvReader{

    private final File csvFile;

    public SimpleCsvReader(String csvPath){

    }

    @Override
    public List<User> read() {
        return null;
    }

    @Override
    public int countRows() {
        return 0;
    }
}
