package manager;

import org.openqa.selenium.By;

public class HelperBase {
    protected final ApplicationManager manager; //ссылка на менеджера

    public HelperBase(ApplicationManager manager) {
        this.manager = manager; //сохраняется в конструкторе
    }

    protected void click(By locator) {
        manager.driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        manager.driver.findElement(locator).clear();
        manager.driver.findElement(locator).sendKeys(text);
    }
}
