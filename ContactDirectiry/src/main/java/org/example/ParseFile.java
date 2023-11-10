package org.example;

import org.example.Profile.ContactDirectoryDefault;

import java.io.*;
import java.util.HashMap;

public class ParseFile {


    private static HashMap<String, String> contactMap = new HashMap<>();
    private static ContactDirectoryStart contactDirectoryStart = new ContactDirectoryStart();
    private static String url;

    public static void parseContact(String path) throws IOException {
        try {
            url = path;
            File file = new File(path);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                contactMap = getContactMap(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, String> getContactMap(String line) {
        String[] contactLine = line.split(";");
        for (int i = 0; i < contactLine.length; i++) {
            contactMap.put(contactLine[0], contactLine[1] + ";" + contactLine[2]);
        }
        return contactMap;
    }

    public static String getUrl() {
        return url;
    }
    public static HashMap<String, String> getContactMap() {
        return contactMap;
    }
}
