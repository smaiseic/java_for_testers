package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openAddContactPage();
        fillContactForm(contact);
        submitContactCreation();
        //openHomePage();
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

    public void removeContact() {
        openHomePage();
        selectContact();
        removeSelectedContact();
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }

    private void removeSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public int getCount() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }
}
