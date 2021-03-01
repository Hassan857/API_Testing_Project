package tests;

import apis.Grades_Collection;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Create_Grade_Api extends BaseTest {

    Grades_Collection gradecollection = new Grades_Collection();
    String gradename , shortname;
    String id;


    @Test(description = "Valid Grade Creation")
    @Description("When I enter valid data in the create grade form And click the ok button, grade should be created")
    @Story("Create Grade")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("focus-case-1637098")
    @Issue("bug-tracker#1")
    public void Valid_Create_Grade()  {

        gradename = filereader.getCellData("grade_name");
        shortname = filereader.getCellData("short_name");
       Response grade_response =  gradecollection.create_grade(gradename , shortname , Token);
        Assert.assertTrue(grade_response.getBody().asString().contains("id"),
                "The  response body doesn't contain the expected message: " + "id");
    }
    @Test(description = "INValid Grade Creation")
    @Description("When I enter long short name in the short Name field then grade should not be created")
    @Story("Create Grade")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("focus-case-1637098")
    @Issue("bug-tracker#1")
    public void Invalid_Create_Grade () {

        gradename = filereader.getCellData("grade_name");
        shortname = filereader.getCellData("Invalid_short_name");
        Response response = gradecollection.create_grade(gradename , shortname , Token);
        Assert.assertTrue(response.getBody().asString().contains("You have reached your maximum limit of characters allowed.") ,
                "validation exist then testcase passed");
    }
}
