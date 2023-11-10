package org.example.Profile;

import org.example.ParseFile;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

public class ContactDirectoryUser implements ContactDirectory {
    private final ParseFile parseFile = new ParseFile();
    @Value("${app.profile}")
    private String path;
    @Value("${app.deleteFile}")
    private boolean delete;
    @Override
    public void contactList() throws IOException {
        System.out.println("Запущен профиль по USER " + path );
        if(delete){
            parseFile.deleteFile(path);
        }
        parseFile.crateFile(path);
    }
}
