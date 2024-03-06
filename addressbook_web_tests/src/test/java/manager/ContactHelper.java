package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openContactPage();
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

    private void openContactPage() {
        if (!manager.isElementPresent(By.xpath("//input[@value='Enter']"))) {
            click(By.linkText("add new"));
        }
    }
}
