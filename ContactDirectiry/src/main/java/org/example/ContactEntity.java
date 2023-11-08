package org.example;

public class ContactEntity {
    private String contactName;
    private String telephoneNumber;
    private String email;

    public ContactEntity() {
    }

    public ContactEntity(String contactName, String telephoneNumber, String email) {
        this.contactName = contactName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "ФИО: " + contactName +
                " \nНомер телефона: " + telephoneNumber +
                " \nEmail: " + email;
    }
}
