package tests;

import common.CommonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase {


    @Test
    public void canModifyContact() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("", "old_first_name", "", "old_last_name", ""));
        }
        var oldContacts = app.contacts().getList();
        var index = new Random().nextInt(oldContacts.size());
        var testData = new ContactData()
                .withId(oldContacts.get(index).id())
                .withFirstName("new_" + CommonFunctions.randomString(5))
                .withLastName("new_" + CommonFunctions.randomString(5));
        app.contacts().modifyContact(testData);
        var newContacts = app.contacts().getList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }
}
