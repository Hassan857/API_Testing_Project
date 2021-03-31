package tests;

import apis.Login;
import com.applitools.eyes.images.Eyes;
import com.shaft.api.RestActions;
import com.shaft.tools.io.ExcelFileManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


    public WebDriver driver;
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

