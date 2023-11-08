package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParseFile {
    HashMap<String, String> contact = new HashMap<>();


    public HashMap<String, String> parseContact(File file) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));


            String line;
            while ((line = reader.readLine()) != null) {
contact = getContactMap(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contact;
    }
    public HashMap<String, String> getContactMap (String line){
        String[] contactLine = line.split(";");
        for(int i = 0; i < contactLine.length; i++){
            contact.put(contactLine[0],contactLine[1] + ";" + contactLine[2]);
        }
        return contact;
    }

}
