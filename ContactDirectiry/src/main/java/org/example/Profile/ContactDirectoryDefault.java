package org.example.Profile;


import org.example.ContactDirectoryStart;
import org.example.ParseFile;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

public class ContactDirectoryDefault implements ContactDirectory {
    private ContactDirectoryStart contactDirectoryStart = new ContactDirectoryStart();

    @Value("${app.profile}")
    private  String path;



    private final ParseFile parseFile = new ParseFile();

    @Override
    public void contactList() throws IOException {
        System.out.println("Программа запущена с настройками по умолчанию");
        parseFile.parseContact(path);
        contactDirectoryStart.addContactInformation();



    }
}
