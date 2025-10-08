package com.recceda.csv;

import com.recceda.elements.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SimpleCsvReader implements CsvReader{

    private final Path csvPath;

    public SimpleCsvReader(String csvPath) {
        this.csvPath = Paths.get(csvPath);
    }

    @Override
    public List<User> read() throws IOException {
        List<String> lines = Files.readAllLines(csvPath);
        if(lines.size()<=1) return List.of();

        return lines.
    }

    @Override
    public int countRows() {
        return 0;
    }
}
