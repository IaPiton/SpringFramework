package org.example.Config;

import org.example.Profile.ContactDirectory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ProfileWorker {
    private final ContactDirectory contactDirectory;
    public ProfileWorker(ContactDirectory contactDirectory) {
        this.contactDirectory = contactDirectory;
    }

    public void doWork() throws IOException {
        contactDirectory.contactList();
    }
}
