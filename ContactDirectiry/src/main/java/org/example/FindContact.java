package org.example;

import java.util.HashMap;

public class FindContact {
   private ContactEntity contactEntity = new ContactEntity();
    public ContactEntity findToName (String name, HashMap<String, String> contact){
        for(String contacts : contact.keySet()){
            if (contacts.equals(name)){
                String[] numberAndEmail = contact.get(contacts).split(";");
                   contactEntity = new ContactEntity(name, numberAndEmail[0], numberAndEmail[1]);
            }
        }
        return contactEntity;
    }
    public ContactEntity findToNumber (String number, HashMap<String, String> contact){
        for(String contacts : contact.keySet()){
            String[] numberAndEmail = contact.get(contacts).split(";");
            if (numberAndEmail[0].equals(number)){
                contactEntity = new ContactEntity(contacts, numberAndEmail[0], numberAndEmail[1]);
            }
        }
        return contactEntity;
    }
    public ContactEntity findToEmail (String email, HashMap<String, String> contact){
        for(String contacts : contact.keySet()){
            String[] numberAndEmail = contact.get(contacts).split(";");
            if (numberAndEmail[1].equals(email)){
                contactEntity = new ContactEntity(contacts, numberAndEmail[0], numberAndEmail[1]);
            }
        }
        return contactEntity;
    }

}
