package tests;

import apis.Login;
import com.shaft.tools.io.ExcelFileManager;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


    ExcelFileManager filereader;
    Login login = new Login();
    String email , password;
    String Token ;



    @BeforeMethod
    public void Valid_Login () {

        filereader = new ExcelFileManager(System.getProperty("user.dir")+"/src/test/resources/TestDataFiles/DataFile.xlsx");
        email = filereader.getCellData("email");
        password = filereader.getCellData("password");
        Token = login.ValidLogin(email , password);
       // Assert.assertNotNull(Token);

    }
}

