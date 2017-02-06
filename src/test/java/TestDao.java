import com.ttem.dao.Dao;
import com.ttem.dao.User;
import org.apache.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class TestDao {

    private static Logger log = Logger.getLogger(TestDao.class);
    private static Dao daoWithEasyMock;

    @BeforeClass
    public static void setUp() throws Exception {
        daoWithEasyMock = EasyMock.createMock(Dao.class);

        EasyMock.expect(daoWithEasyMock.selectUserById(1)).andReturn(new User(1));
        EasyMock.expect(daoWithEasyMock.selectAllUsers()).andReturn(new ArrayList<>());

        EasyMock.replay(daoWithEasyMock);
    }

    @Test
    public void testSelectUserById() throws Exception {
        int expectedId = 1;

        int inputId = 1;

        int actualId = daoWithEasyMock.selectUserById(inputId).getId();

        Assert.assertEquals(expectedId, actualId);
    }

    @Test
    public void testSelectAllUsers() throws Exception {
        List<User> expectedArray = new ArrayList<>();

        List<User> actualArray = daoWithEasyMock.selectAllUsers();

        Assert.assertSame(expectedArray.getClass(), actualArray.getClass());
    }

    @Test
    public void testDaoSingleton() throws Exception {
        Dao expectedDao = Dao.getInstance();

        Dao testDao = Dao.getInstance();

        Assert.assertSame(expectedDao,testDao);
        log.info(expectedDao.toString() + " == " + testDao.toString());
    }

    @AfterClass
    public static void verifyEasyMock() {
        EasyMock.verify(daoWithEasyMock);
    }
}
