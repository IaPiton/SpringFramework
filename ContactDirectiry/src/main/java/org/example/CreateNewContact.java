package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateNewContact {
    private final String contactNames = "Введите ФИО в формате (Иванов Иван Иванович)";
    private final String contactEmail = "Введите email в формате (exemple@mail.ru)";
    private final String contactNumber = "Введите номер телефона в формате (+79999999999)";
    private final String deleteContact = "Введите ФИО или номер телефона или Email контакта который хотите удалить";
    private ContactEntity contactEntity = new ContactEntity();
    private FindContact findContact = new FindContact();
    private String contactName;
    private String email;
    private String number;
    private String delete;
    private WriteFile writeFile = new WriteFile();
    private String regexContactName = "([А-Яа-я]+)\\s*([А-Яа-я]+)\\s*([А-Яа-я]+)";
    private String regexContactEmail = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private String regexContactNumber = "\\+\\d{11}$";
    private Pattern pattern;
    private boolean isValid = true;

    Scanner scanner = new Scanner(System.in);

    public void addNameContact() throws IOException {
        while (isValid) {
            System.out.println(contactNames);
            contactName = scanner.nextLine();
            String[] fullName = contactName.split(" ");
            if (isValidContactName(contactName) && fullName.length == 3) {
                contactEntity.setContactName(contactName);
                isValid = false;
            } else {
                System.out.println("Веддено некоректное ФИО");
            }
        }
        while (!isValid) {
            System.out.println(contactEmail);
            email = scanner.nextLine();
            if (isValidContactEmail(email)) {
                contactEntity.setEmail(email);
                isValid = true;
            } else {
                System.out.println("Ведден некорректный Email");
            }
        }
        while (isValid) {
            System.out.println(contactNumber);
            number = scanner.nextLine();
            if (isValidContactNumber(number)) {
                contactEntity.setTelephoneNumber(number);
                isValid = false;
            } else {
                System.out.println("Ведден некорректный номер телефона");
            }
        }
        writeFile.writeContact(contactEntity);
    }

    public void listContact() throws IOException {
        ParseFile.parseContact(ParseFile.getUrl());
        HashMap<String, String> listContact = ParseFile.getContactMap();
        for (String contact : listContact.keySet()) {
            String[] emailAndNumber = listContact.get(contact).split(";");
            System.out.println(contact + " " + emailAndNumber[0] + " " + emailAndNumber[1]);
        }
    }

    public boolean isValidContactName(String username) {
        pattern = Pattern.compile(regexContactName);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public boolean isValidContactEmail(String email) {
        pattern = Pattern.compile(regexContactEmail);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isValidContactNumber(String number) {
        pattern = Pattern.compile(regexContactNumber);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public void deleteContact() throws IOException {
        boolean isDelete = true;
        while (isDelete) {
            System.out.println(deleteContact);
            delete = scanner.nextLine();
            String[] fullName = delete.split(" ");
            if (isValidContactName(delete) && fullName.length == 3) {
            deleteToNameContact(delete);
            System.out.println("Контакт с именем " + delete +" УДАЛЕН!");
            isDelete = false;
        } else if (isValidContactNumber(delete)) {
            deleteToNumberContact(delete);
            System.out.println("Контакт с телефоном " + delete +" УДАЛЕН!");
            isDelete = false;
        } else if (isValidContactEmail(delete)) {
            deleteToEmailContact(delete);
            System.out.println("Контакт с Email " + delete +" УДАЛЕН!");
            isDelete = false;
        }else{
            System.out.println("Некорректный ввод");
        }
        }
    }

    private void deleteToEmailContact(String deleteEmail) throws IOException {
        HashMap<String, String> listContact = ParseFile.getContactMap();
        contactEntity = findContact.findToEmail(deleteEmail, listContact);
        delete(listContact, contactEntity);
    }

    private void deleteToNumberContact(String deleteNumber) throws IOException {
        HashMap<String, String> listContact = ParseFile.getContactMap();
        contactEntity = findContact.findToNumber(deleteNumber, listContact);
        delete(listContact, contactEntity);
    }

    private void deleteToNameContact(String deleteName) throws IOException {
        HashMap<String, String> listContact = ParseFile.getContactMap();
        contactEntity = findContact.findToName(deleteName, listContact);
        delete(listContact, contactEntity);
    }

    public void delete (HashMap<String,String> contacts, ContactEntity contactEntity) throws IOException {
        FileWriter fileWriter = new FileWriter(ParseFile.getUrl());
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
    }



}
