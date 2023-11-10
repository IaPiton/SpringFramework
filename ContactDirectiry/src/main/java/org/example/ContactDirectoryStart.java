package org.example;

import java.io.IOException;
import java.util.Scanner;

public class ContactDirectoryStart {
    private CreateNewContact createNewContact = new CreateNewContact();
    private final String start = "Для начала работы программы введите команду: \n" +
            "ADD - Добавить контакт \n" +
            "LIST - Посмотреть список контактов \n" +
            "DELETE - Удалить контакт \n";


    public void addContactInformation() throws IOException {
        System.out.println(start);
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String command = scanner.nextLine().toLowerCase();
            switch (command) {
                case ("add"):
                    createNewContact.addNameContact();
                    break;
                case ("list"):
                    createNewContact.listContact();
                    break;
                case ("delete"):
                    createNewContact.deleteContact();
                    break;
            }
        }
    }


    private String contactName;
    private String telephoneNumber;
    private String email;
}
