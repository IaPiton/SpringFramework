package org.example;


import org.springframework.beans.factory.annotation.Value;

public class ContactDirectiryDefault implements ContactDirectiry{
    @Value("${app.url}")
    private String url;
    @Override
    public void contactList() {
        System.out.println("Запущен профиль по DEFAULT " + url );
    }
}
