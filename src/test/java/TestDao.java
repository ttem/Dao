import com.ttem.dao.Dao;
import com.ttem.data.*;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class TestDao {

    private static Logger log = Logger.getLogger(TestDao.class);


    @Test
    public void daoSingleton() throws Exception {
        Dao expectedDao = Dao.getInstance();

        Dao actualDao = Dao.getInstance();

        Assert.assertSame(expectedDao,actualDao);
    }

    @Test
    public void setSourceOfDataWhenInputDataBase() throws Exception {
        SourceType expectedSourceType = SourceType.DATA_BASE;
        Data expectedData = new DataBase();

        SourceType inputSourceType = SourceType.DATA_BASE;

        Dao testDao = Dao.getInstance();
        testDao.setSourceOfData(inputSourceType);

        SourceType actualSourceType = testDao.getCurrentSourceType();
        Data actualData = testDao.getData();

        Assert.assertSame(expectedSourceType, actualSourceType);
        Assert.assertSame(expectedData.getClass(), actualData.getClass());
    }

    @Test
    public void setSourceOfDataWhenInputXml() throws Exception {
        SourceType expectedSourceType = SourceType.XML;
        Data expectedData = new Xml();

        SourceType inputSourceType = SourceType.XML;

        Dao testDao = Dao.getInstance();
        testDao.setSourceOfData(inputSourceType);

        SourceType actualSourceType = testDao.getCurrentSourceType();
        Data actualData = testDao.getData();

        Assert.assertSame(expectedSourceType, actualSourceType);
        Assert.assertSame(expectedData.getClass(), actualData.getClass());
    }

    @Test
    public void setSourceOfDataWhenInputWebService() throws Exception {
        SourceType expectedSourceType = SourceType.WEB_SERVICE;
        Data expectedData = new WebService();

        SourceType inputSourceType = SourceType.WEB_SERVICE;

        Dao testDao = Dao.getInstance();
        testDao.setSourceOfData(inputSourceType);

        SourceType actualSourceType = testDao.getCurrentSourceType();
        Data actualData = testDao.getData();

        Assert.assertSame(expectedSourceType, actualSourceType);
        Assert.assertSame(expectedData.getClass(), actualData.getClass());
    }

    @Test
    public void setSourceOfDataDefault() throws Exception {
        SourceType expectedSourceType = Dao.getDefaultSourceType();

        Dao testDao = Dao.getInstance();

        SourceType actualSourceType = testDao.getCurrentSourceType();

        Assert.assertSame(expectedSourceType, actualSourceType);
    }
}
