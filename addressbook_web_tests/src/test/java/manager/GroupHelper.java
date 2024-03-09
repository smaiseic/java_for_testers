package manager;

import model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper extends HelperBase {

    public GroupHelper(ApplicationManager manager) {
        //вызывается конструктор базового класса и значение параметра manager передается в базовый класс
        //в его конструктор и там сохраняется, но поскольку класс GroupHepler расширяет базовый класс, то переменна manager,
        //которая находится в базовом классе будет доступна
        super(manager);
    }

    public void createGroup(GroupData group) {
        openGroupPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    public void modifyGroup(GroupData modifiedGroup) {
        openGroupPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(modifiedGroup);
        submitGroupModification();
        returnToGroupPage();
    }


    public void removeGroup() {
        openGroupPage();
        selectGroup();
        removeSelectedGroup();
        returnToGroupPage();
    }

    private void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.name());
        type(By.name("group_header"), group.header());
        type(By.name("group_footer"), group.footer());
    }


    public void openGroupPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }

    private void submitGroupCreation() {
        click(By.name("submit"));
    }

    private void initGroupCreation() {
        click(By.name("new"));
    }

    private void removeSelectedGroup() {
        click(By.name("delete"));
    }


    private void returnToGroupPage() {
        click(By.linkText("groups"));
    }

    private void submitGroupModification() {
        click(By.name("update"));
    }


    private void initGroupModification() {
        click(By.name("edit"));
    }

    private void selectGroup() {
        click(By.name("selected[]"));
    }

    public int getCount() {
        openGroupPage();
        return manager.driver.findElements(By.name("selected[]")).size(); //list
    }
}
