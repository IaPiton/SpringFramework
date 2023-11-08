package org.example;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        FindContact findContact = new FindContact();
        ContactEntity contactEntity = new ContactEntity();
        String name = "Веселова Ольга Вячеславовна";
        String number = "+79011235489";
        String email = "iapiton@yandex.ru";
        File file = new File("src/main/resources/default-contacts.txt");
        ParseFile parseFile = new ParseFile();
        HashMap<String, String> contact = parseFile.parseContact(file);
        contactEntity = findContact.findToName(name, contact);
        System.out.println(contactEntity.toString());
//        contactEntity = findContact.findToNumber(number, contact);
//        System.out.println(contactEntity.toString());
//        contactEntity = findContact.findToEmail(email, contact);
//        System.out.println(contactEntity.toString());
  DeleteContact deleteContact = new DeleteContact();
        System.out.println( deleteContact.addContact("Веселова", "+79038544565","sdsdf@sdfsdf.ru", file));

    }
}