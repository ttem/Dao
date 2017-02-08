import com.ttem.data.DataBase;
import com.ttem.data.WebService;
import com.ttem.data.Xml;
import org.junit.Assert;
import org.junit.Test;

public class TestDataSingleton {

    @Test
    public void dataBase() {
        DataBase expectedDataBase = DataBase.getInstance();

        DataBase actualDataBase = DataBase.getInstance();

        Assert.assertSame(expectedDataBase, actualDataBase);
    }

    @Test
    public void xml() {
        Xml expectedXml = Xml.getInstance();

        Xml actualXml = Xml.getInstance();

        Assert.assertSame(expectedXml, actualXml);
    }

    @Test
    public void webService() {
        WebService expectedWebService = WebService.getInstance();

        WebService actualWebService = WebService.getInstance();

        Assert.assertSame(expectedWebService, actualWebService);
    }
}
