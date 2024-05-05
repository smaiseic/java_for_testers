package model;

public record ContactData(
        String id,
        String firstname,
        String middlename,
        String lastname,
        String photo,
        String address,
        String home,
        String mobile,
        String work,
        String secondary) {

    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withLastName(String lastname) {
        return new ContactData(this.id, this.firstname, this.middlename, lastname, this.photo, this.address, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withFirstName(String firstname) {
        return new ContactData(this.id, firstname, this.middlename, lastname, this.photo, this.address, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.middlename, this.lastname, this.photo, this.address, this.home, this.mobile, this.work, this.secondary);
    }
    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, photo, this.address, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.photo, address, this.home, this.mobile, this.work, this.secondary);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.photo, address, home, this.mobile, this.work, this.secondary);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.photo, address, this.home, mobile, this.work, this.secondary);
    }

    public ContactData withWork(String work) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.photo, address, this.home, this.mobile, work, this.secondary);
    }

    public ContactData withSecondary(String secondary) {
        return new ContactData(this.id, this.firstname, this.middlename, this.lastname, this.photo, address, this.home, this.mobile, this.work, secondary);
    }
}
