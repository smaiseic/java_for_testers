import java.io.File;
import java.io.IOException;

public class Hello {
    public static void main(String[] args) throws IOException {
        files();
//        var x = 1;
//        var y = 0;
//        if (y == 0) {
//            System.out.println("Division by zero is not allowed");
//        } else {
//            int z = divide(x, y);
//            System.out.println("Hey again!");
//        }
//

    }

    private static int divide(int x, int y) {
        var z = x / y;
        return z;
    }

    public static void files() throws IOException {
        System.out.println(new File("sandbox/build.gradle").getAbsoluteFile());
        System.out.println(new File("sandbox/build.gradle").getCanonicalPath());
        System.out.println(new File("").getAbsoluteFile());
        System.out.println(new File("sandbox/build.gradle").toURI());
    }
}
