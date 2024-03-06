package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void canCreateContactWithEmptyFields() {
        app.contacts().createContact(new ContactData());
    }

    @Test
    public void canCreateContact() {
        app.contacts().createContact(new ContactData("first_name", "middle_name", "last_name"));
    }

    @Test
    public void canCreateContactWithLastNameOnly() {
        app.contacts().createContact(new ContactData().withLastName("last_name"));
    }

}
