package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser", "firefox"));
    }

    public static String randomString(int n) {
        var rnd = new Random();
        var result = "";
        for (int i = 0; i < n; i++) {
            //('a' + rnd.nextInt(27)) -- число Ascii, rnd.nextInt(27) - число от 0 до 26 -- нужно все привести к типу char
            result = result + (char)('a' + rnd.nextInt(26));
        }
        if (n < 20) {
            result = result + '\'';
        }
        return result;
    }
}
