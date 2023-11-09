package org.example.Profile;


import org.example.ParseFile;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

public class ContactDirectoryDefault implements ContactDirectory {
    @Value("${app.profile}")
    private String path;
    private final ParseFile parseFile = new ParseFile();

    @Override
    public void contactList() throws IOException {
        System.out.println("Программа запущена с настройками по умолчанию");
        parseFile.parseContact(path);



    }
}
