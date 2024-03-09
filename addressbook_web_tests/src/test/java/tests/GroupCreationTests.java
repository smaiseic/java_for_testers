package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class GroupCreationTests extends TestBase {

    public static List<String> groupNameProvider() {
        var result = new ArrayList<>(List.of("group name", "group name'"));
        for (int i = 0; i < 5; i++) {
            result.add(randomString(i * 10));
        }
        return result;
    }

//    @ParameterizedTest
//    @ValueSource(strings = {"group name", "group name'"})
//    public void canCreateGroup(String name) {
//        int groupCount = app.groups().getCount();
//        System.out.println(groupCount);
//        app.groups().createGroup(new GroupData(name, "group header", "group footer"));
//        int newGroupCount = app.groups().getCount();
//        System.out.println(newGroupCount);
//        Assertions.assertEquals(groupCount + 1, newGroupCount);
//    }

    @Test
    public void canCreateGroupWithEmptyName() {
        app.groups().createGroup(new GroupData());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        app.groups().createGroup(new GroupData().withName("some name"));
    }

    @ParameterizedTest
    @MethodSource("groupNameProvider")
    public void canCreateMultipleGroup(String name) {
        int n = 5;
        int groupCount = app.groups().getCount();

        app.groups().createGroup(new GroupData(name, "group header", "group footer"));

        int newGroupCount = app.groups().getCount();
        Assertions.assertEquals(groupCount + n, newGroupCount);
    }
}
