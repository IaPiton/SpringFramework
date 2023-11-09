package org.example.Config;

import org.example.ContactDirectiry;
import org.springframework.stereotype.Component;

@Component
public class ProfileWorker {
    private final ContactDirectiry contactDirectiry;


    public ProfileWorker(ContactDirectiry contactDirectiry) {
        this.contactDirectiry = contactDirectiry;
    }

    public void doWork(){
        contactDirectiry.contactList();
    }
}
