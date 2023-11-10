package org.example;

import org.example.Profile.ContactDirectoryDefault;
import org.example.Profile.ContactDirectoryUser;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {
    @Value("${app.profile}")
    private  String path;

    public void writeContact (ContactEntity contactEntity) throws IOException {
        File file = new File(ParseFile.getUrl());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(contactEntity.getContactName()).append(";").append(contactEntity.getTelephoneNumber()).append(";").append(contactEntity.getEmail()).append("\n");
        PrintWriter writer = new PrintWriter(new FileWriter(file, true));
        writer.append(stringBuilder);
        writer.flush();
        writer.close();
        System.out.println("Контакт: " + contactEntity.getContactName() + " ДОБАВЛЕН!");
    }

}
