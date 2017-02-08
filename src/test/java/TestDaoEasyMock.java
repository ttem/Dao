import com.ttem.dao.Dao;
import com.ttem.dao.User;
import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TestDaoEasyMock {

    private static Dao daoWithEasyMock;

    @BeforeClass
    public static void setUp() throws Exception {
        TestDaoEasyMock.daoWithEasyMock = EasyMock.createMock(Dao.class);

        EasyMock.expect(TestDaoEasyMock.daoWithEasyMock.selectUserById(1)).andReturn(new User(1));
        EasyMock.expect(TestDaoEasyMock.daoWithEasyMock.selectAllUsers()).andReturn(new ArrayList<>());

        EasyMock.replay(TestDaoEasyMock.daoWithEasyMock);
    }

    @Test
    public void selectUserByIdWithEasyMock() throws Exception {
        int expectedId = 1;

        int inputId = 1;

        int actualId = TestDaoEasyMock.daoWithEasyMock.selectUserById(inputId).getId();

        Assert.assertEquals(expectedId, actualId);
    }

    @Test
    public void selectAllUsersWithEasyMock() throws Exception {
        List<User> expectedArray = new ArrayList<>();

        List<User> actualArray = TestDaoEasyMock.daoWithEasyMock.selectAllUsers();

        Assert.assertSame(expectedArray.getClass(), actualArray.getClass());
    }


    @AfterClass
    public static void verifyEasyMock() {
        EasyMock.verify(TestDaoEasyMock.daoWithEasyMock);
    }
}
