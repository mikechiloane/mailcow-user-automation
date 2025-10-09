package com.recceda;


import com.recceda.csv.SimpleCsvReader;
import com.recceda.elements.User;
import com.recceda.http.api.MailBoxAPI;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AutomationApp
{
    public static void main( String[] args )
    {
        if (args.length == 0) {
            System.out.println("Please provide the path to the CSV file as an argument.");
            return;
        }

        String csvPath = args[0];
        SimpleCsvReader simpleCsvReader = new SimpleCsvReader(csvPath);
        MailBoxAPI mailBoxAPI = new MailBoxAPI();

        try {
            List<User> users = simpleCsvReader.read();
            System.out.println("Found " + users.size() + " users in the CSV file.");

            for (User user : users) {
                try {
                    System.out.println("Creating email for user: " + user.getUsername());
                    mailBoxAPI.createEmailForUser(user);
                    System.out.println("Successfully created email for user: " + user.getUsername());
                } catch (ExecutionException | InterruptedException e) {
                    System.err.println("Failed to create email for user: " + user.getUsername());
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
