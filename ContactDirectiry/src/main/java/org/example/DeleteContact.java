package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class DeleteContact {
    public String deleteToName (HashMap<String,String> contacts, ContactEntity contactEntity, File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        StringBuilder contactDirectiry = new StringBuilder();
        fileWriter.write("");
        fileWriter.flush();
        for(String contact : contacts.keySet()){
            if(!(contact.equals(contactEntity.getContactName()))){
            contactDirectiry.append(contact).append(";").append(contacts.get(contact)).append("\n");
            }
        }
        fileWriter.write(contactDirectiry.toString());
        fileWriter.flush();
        fileWriter.close();
        String result = "Контакт: " + contactEntity.getContactName() + " УДАЛЕН!";
        return result;
    }
    public String addContact (String name, String number, String email, File file) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append(";").append(number).append(";").append(email);
        PrintWriter writer = new PrintWriter(new FileWriter(file, true));
        writer.append(stringBuilder);
        writer.flush();
        writer.close();
        String result = "Контакт: " + name + " Добавлен!";
        return result;
    }


}
