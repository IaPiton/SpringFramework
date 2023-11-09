package org.example;

import org.springframework.beans.factory.annotation.Value;

public class ContactDirectiryUser implements ContactDirectiry{
    @Value("${app.url}")
    private String url;
    @Override
    public void contactList() {
        System.out.println("Запущен профиль по USER " + url );
    }
}
