package manager;

import org.openqa.selenium.By;

import java.nio.file.Paths;

public class HelperBase {
    protected final ApplicationManager manager; //ссылка на менеджера

    public HelperBase(ApplicationManager manager) {
        this.manager = manager; //сохраняется в конструкторе
    }

    protected void click(By locator) {
        manager.wait.until(d -> d.findElement(locator)).click();
        //manager.driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        manager.driver.findElement(locator).clear();
        manager.driver.findElement(locator).sendKeys(text);
    }

    protected void attach(By locator, String file) {
        manager.driver.findElement(locator).sendKeys(Paths.get(file).toAbsolutePath().toString());
    }

    protected void openHomePage() {
        click(By.linkText("home"));
        manager.wait.until(d -> d.findElement(By.xpath("//strong[text()='Number of results: ']")));
    }
}
