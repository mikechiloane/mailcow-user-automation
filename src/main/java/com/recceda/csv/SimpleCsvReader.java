package com.recceda.csv;

import com.recceda.elements.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleCsvReader implements CsvReader{

    private final Path csvPath;

    public SimpleCsvReader(String csvPath) {
        this.csvPath = Paths.get(csvPath);
    }

    @Override
    public List<User> read() throws IOException {
        List<String> lines = Files.readAllLines(csvPath);
        if(lines.size()<=1) return List.of();

        return lines.stream()
                .skip(1)
                .map(SimpleCsvReader::createUserFromLine)
                .collect(Collectors.toList());
    }

    @Override
    public int countRows() throws IOException {
        try(Stream<String> lines = Files.lines(csvPath)){
            return (int) lines.skip(1).count();
        }
    }

    public static User createUserFromLine(String line){
        String[] entries = line.split(",");
        return new User(entries[0], entries[1]);
    }
}
