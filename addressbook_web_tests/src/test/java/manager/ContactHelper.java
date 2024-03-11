package manager;

import model.ContactData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openAddContactPage();
        fillContactForm(contact);
        submitContactCreation();
    }

    private void submitContactCreation() {
        click(By.xpath("//input[@value='Enter' and @name='submit']"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.first_name());
        type(By.name("middlename"), contact.middle_name());
        type(By.name("lastname"), contact.last_name());

    }

    private void openAddContactPage() {
        if (!manager.isElementPresent(By.xpath("//input[@value='Enter']"))) {
            click(By.linkText("add new"));
        }
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectContact(contact);
        removeSelectedContact();
    }

    private void selectContact(ContactData contact) {
        click(By.xpath(String.format("//input[@id='%s']", contact.id())));
    }

    private void removeSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public int getCount() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getList() {
        openHomePage();
        var contacts = new ArrayList<ContactData>();
        var trs = manager.driver.findElements(By.name("entry"));
        for (var tr : trs ) {
            var lastName = tr.findElement(By.xpath(".//td[2]")).getText();
            var firstName = tr.findElement(By.xpath(".//td[3]")).getText();
            var id = tr.findElement(By.name("selected[]")).getAttribute("value");
            contacts.add(new ContactData().withId(id).withLastName(lastName).withFirstName(firstName));
        }
        return contacts;
    }

    public void modifyContact(ContactData contact) {
        openHomePage();
        initContactEdit(contact);
        fillContactForm(contact);
        submitContactModification();
    }

    private void submitContactModification() {
        manager.driver.findElement(By.name("update")).click();
    }

    private void initContactEdit(ContactData contact) {
        manager.driver.findElement(
                By.xpath(String.format("//input[@id='%s']/../following-sibling::td//img[@title='Edit']", contact.id()))).click();
    }
}
