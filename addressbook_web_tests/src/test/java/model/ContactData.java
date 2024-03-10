package model;

public record ContactData(String id, String first_name, String middle_name, String last_name) {

    public ContactData() {
        this("", "", "", "");
    }

    public ContactData withLastName(String last_name) {
        return new ContactData(this.id, this.first_name, this.middle_name, last_name);
    }

    public ContactData withFirstName(String first_name) {
        return new ContactData(this.id, first_name, this.middle_name, last_name);
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.first_name, this.middle_name, this.last_name);
    }
}
