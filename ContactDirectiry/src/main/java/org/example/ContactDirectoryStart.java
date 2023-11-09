package org.example;

import java.util.Scanner;

public class ContactDirectoryStart {
    private AddNewContact addNewContact = new AddNewContact();
    private final String start = "Для начала работы программы введите команду: \n" +
            "ADD - Добавить контакт \n" +
            "LIST - Посмотреть список контактов \n" +
            "DELETE - Удалить контакт \n";


    public void addContactInformation() {
        System.out.println(start);
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String command = scanner.nextLine();
            switch (command){
                case ("add"):
                    addNewContact.addNameContact();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
        }
    }



    private String contactName;
    private String telephoneNumber;
    private String email;
}
