import com.ttem.dao.Dao;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDao {

    private Dao DaoWithEasyMock;

    @Before
    public void setUp() throws Exception {
        this.DaoWithEasyMock = EasyMock.createMock(Dao.class);
    }

    @Test
    public void testDaoSingleton() throws Exception {
        Dao expectedDao = Dao.getInstance();

        Dao testDao = Dao.getInstance();

        Assert.assertSame(expectedDao,testDao);
    }
}
