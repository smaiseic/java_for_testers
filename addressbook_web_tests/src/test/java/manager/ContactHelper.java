package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openAddContactPage();
        fillContactForm(contact);
        submitContactCreation();
    }

    public void createContactInGroup(ContactData contact, GroupData group) {
        openAddContactPage();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
        openHomePage();
    }

    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
        //new Select(manager.driver.findElement(By.name("new_group"))).selectByVisibleText(group.name());
    }

    private void sortByGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByVisibleText(group.name());
    }

    private void submitContactCreation() {
        click(By.xpath("//input[@value='Enter' and @name='submit']"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("middlename"), contact.middlename());
        type(By.name("lastname"), contact.lastname());
        type(By.name("address"), contact.address());
        if (!contact.photo().equals("")) {
            attach(By.name("photo"), contact.photo());
        }
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

    public void removeAllContacts() {
        openHomePage();
        selectAllContacts();
        removeSelectedContact();
    }

    private void selectAllContacts() {
        click(By.xpath("//input[@id='MassCB']"));
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

    private void submitRemoveContactFromGroup() {
        manager.driver.findElement(By.name("remove")).click();
    }

    public void removeContactFromGroup(ContactData contact, GroupData group) {
        openHomePage();
        sortByGroup(group);
        selectContact(contact);
        submitRemoveContactFromGroup();
        openHomePage();
    }

    public String getPhones(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[6]", contact.id()))).getText();
    }

    public Map<String, String> getPhones() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var phones = row.findElements(By.tagName("td")).get(5).getText();
            result.put(id, phones);
        }
        return result;
    }
}
