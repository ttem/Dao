import com.ttem.dao.Dao;
import com.ttem.data.*;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDao {

    private static Logger log = Logger.getLogger(TestDao.class);
    private Dao testDao;

    @Before
    public void setUp() {
        this.testDao = Dao.getInstance();
    }

    @Test
    public void daoSingleton() {
        Dao expectedDao = Dao.getInstance();

        Dao actualDao = Dao.getInstance();

        Assert.assertSame(expectedDao,actualDao);
    }

    @Test
    public void setSourceOfDataWhenInputDataBase() {
        SourceType expectedSourceType = SourceType.DATA_BASE;
        Data expectedData = new DataBase();

        SourceType inputSourceType = SourceType.DATA_BASE;

        this.testDao.setSourceOfData(inputSourceType);

        SourceType actualSourceType = this.testDao.getCurrentSourceType();
        Data actualData = this.testDao.getData();

        Assert.assertSame(expectedSourceType, actualSourceType);
        Assert.assertSame(expectedData.getClass(), actualData.getClass());
    }

    @Test
    public void setSourceOfDataWhenInputXml() {
        SourceType expectedSourceType = SourceType.XML;
        Data expectedData = new Xml();

        SourceType inputSourceType = SourceType.XML;

        this.testDao.setSourceOfData(inputSourceType);

        SourceType actualSourceType = this.testDao.getCurrentSourceType();
        Data actualData = this.testDao.getData();

        Assert.assertSame(expectedSourceType, actualSourceType);
        Assert.assertSame(expectedData.getClass(), actualData.getClass());
    }

    @Test
    public void setSourceOfDataWhenInputWebService() {
        SourceType expectedSourceType = SourceType.WEB_SERVICE;
        Data expectedData = new WebService();

        SourceType inputSourceType = SourceType.WEB_SERVICE;

        this.testDao.setSourceOfData(inputSourceType);

        SourceType actualSourceType = this.testDao.getCurrentSourceType();
        Data actualData = this.testDao.getData();

        Assert.assertSame(expectedSourceType, actualSourceType);
        Assert.assertSame(expectedData.getClass(), actualData.getClass());
    }

    @Test
    public void setSourceOfDataDefault() {
        SourceType expectedSourceType = Dao.getDefaultSourceType();

        SourceType actualSourceType = this.testDao.getCurrentSourceType();

        Assert.assertSame(expectedSourceType, actualSourceType);
    }
}
