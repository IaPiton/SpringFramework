package org.example;

import java.io.*;
import java.util.HashMap;

public class ParseFile {
    private HashMap<String, String> contactMap = new HashMap<>();
    private ContactDirectoryStart contactDirectoryStart = new ContactDirectoryStart();

    public void parseContact(String path) throws IOException {
        try {
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
        contactDirectoryStart.addContactInformation();
    }

    public HashMap<String, String> getContactMap(String line) {
        String[] contactLine = line.split(";");
        for (int i = 0; i < contactLine.length; i++) {
            contactMap.put(contactLine[0], contactLine[1] + ";" + contactLine[2]);
        }
        return contactMap;
    }

}
