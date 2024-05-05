package tests;

import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.hbm().getContactCount() == 0) {
            app.contacts().createContact(new ContactData("", "first_name", "middle_name", "last_name", "", "", "", "", "", ""));
        }
        var oldContacts = app.hbm().getContactList();
        var index = new Random().nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);
    }

    public void canRemoveAllContactAtOnce() {
        if (app.hbm().getContactCount() == 0) {
            app.contacts().createContact(new ContactData("", "first_name", "middle_name", "last_name", "", "", "", "", "", ""));
        }
        if (app.hbm().getGroupCount() != 0) {
            // to avoid issues with DB
            app.groups().removeAllGroups();
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0, app.hbm().getContactCount());
    }

    @Test
    public void canRemoveContactFromGroup() {
        ContactData contact = new ContactData()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastName(CommonFunctions.randomString(10))
                .withAddress(CommonFunctions.randomString(10))
                .withPhoto(randomFile("src/test/resources/images"));
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }

        var group = app.hbm().getGroupList().get(0);
        app.contacts().createContactInGroup(contact, group);
        var oldRelated = app.hbm().getContactsInGroup(group);
        var randomContact = oldRelated.get(new Random().nextInt(oldRelated.size()));
        app.contacts().removeContactFromGroup(randomContact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(newRelated.size() + 1, oldRelated.size());




//        app.groups().createGroup(new GroupData().withName("group for removal"));
//        app.contacts().createContactInGroup(contact, app.groups().getList().get());
//        var group = app.hbm().getGroupList().get(0);
//        var oldRelated = app.hbm().getContactsInGroup(group);
//        app.contacts().createContactInGroup(contact, group);
//        var newRelated = app.hbm().getContactsInGroup(group);
//        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
    }
}
