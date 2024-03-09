package tests;

import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void canCreateGroup() {
        int groupCount = app.groups().getCount();
        System.out.println(groupCount);
        app.groups().createGroup(new GroupData("group name", "group header", "group footer"));
        int newGroupCount = app.groups().getCount();
        System.out.println(newGroupCount);
        Assertions.assertEquals(groupCount + 1, newGroupCount);
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        app.groups().createGroup(new GroupData());
    }

    @Test
    public void canCreateGroupWithNameOnly() {
        app.groups().createGroup(new GroupData().withName("some name"));
    }
}
