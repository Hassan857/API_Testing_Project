package tests;

import apis.Grades_Collection;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Get_Grades_Api extends BaseTest{

    Grades_Collection gradecollection = new Grades_Collection();


    @Test(description = "Valid get grades")
    @Description("test retrieve all grades")
    @Story("get Grades")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("focus-case-1637098")
    @Issue("bug-tracker#1")
    public void Valid_Get_Grade()  {

        Response grade_response =  gradecollection.get_grades(Token);
        Assert.assertTrue(grade_response.getBody().asString().contains("name"),
                "The  response body doesn't contain the expected message: " + "name");
    }
}
