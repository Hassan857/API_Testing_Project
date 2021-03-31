package tests;

import apis.Grades_Collection;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.apache.commons.compress.utils.IOUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Files;

public class Test_Download_Grades_Template extends BaseTest{


    Grades_Collection gradecollection = new Grades_Collection();


    @Test(description = "Valid get grades")
    @Description("test retrieve all grades")
    @Story("get Grades")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("focus-case-1637098")
    @Issue("bug-tracker#1")
    public void Valid_Downlaod_Grades_Temp() throws IOException {

        Response grade_downlaod_response =  gradecollection.get_grade_template(Token);
        //InputStream inputstraem = grade_downlaod_response.asInputStream();


      //  File file = new File(System.getProperty("user.dir")+"/downloads/myfile.xlsx");
      //  OutputStream outStream = new FileOutputStream(file);
       // outStream.write(inputstraem);
    }
}
