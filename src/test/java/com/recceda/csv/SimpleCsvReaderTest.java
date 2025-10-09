package com.recceda.csv;

import com.recceda.elements.User;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SimpleCsvReaderTest extends TestCase {



    public void testRead() throws IOException {
        SimpleCsvReader  reader = new SimpleCsvReader("src/test/resources/users.csv");
        List<User> users = reader.read();
        assertEquals(20, users.size());
    }

    public void testCountRows() throws IOException {
        SimpleCsvReader  reader = new SimpleCsvReader("src/test/resources/users.csv");
        assertEquals(20, reader.countRows());
    }

}