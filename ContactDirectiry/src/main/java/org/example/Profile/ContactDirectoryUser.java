package org.example.Profile;

import org.springframework.beans.factory.annotation.Value;

public class ContactDirectoryUser implements ContactDirectory {
    @Value("${app.profile}")
    private String url;
    @Override
    public void contactList() {
        System.out.println("Запущен профиль по USER " + url );
    }
}
