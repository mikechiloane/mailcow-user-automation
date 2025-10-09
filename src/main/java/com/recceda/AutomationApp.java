package com.recceda;


import com.recceda.csv.SimpleCsvReader;
import com.recceda.elements.User;
import com.recceda.http.api.MailBoxAPI;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class AutomationApp
{

    private final static Logger log = Logger.getLogger(AutomationApp.class.getName());
    public static void main( String[] args )
    {
        if (args.length == 0) {
            log.severe("Please provide the path to the CSV file as an argument.");
            return;
        }

        String csvPath = args[0];
        SimpleCsvReader simpleCsvReader = new SimpleCsvReader(csvPath);
        MailBoxAPI mailBoxAPI = new MailBoxAPI();

        try {
            List<User> users = simpleCsvReader.read();
            log.info("Found " + users.size() + " users in the CSV file.");

            for (User user : users) {
                try {
                    log.info("Creating email for user: " + user.getUsername());
                    mailBoxAPI.createEmailForUser(user);
                    log.info("Successfully created email for user: " + user.getUsername());
                }  catch (Exception e){
                    log.severe("Failed to create email for user: " + user.getUsername() +" "+e);
                }
            }
        } catch (IOException e) {
            log.severe("Error reading CSV file: " + e.getMessage());
        }
    }
}
