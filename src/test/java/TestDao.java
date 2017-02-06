import com.ttem.dao.Dao;
import org.junit.Assert;
import org.junit.Test;

public class TestDao {

    @Test
    public void testDaoSingleton() throws Exception {
        Dao expectedDao = Dao.getInstance();

        Dao testDao = Dao.getInstance();

        Assert.assertSame(expectedDao,testDao);
    }
}
