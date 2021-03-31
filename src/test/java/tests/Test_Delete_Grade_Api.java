package tests;

import apis.Grades_Collection;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Test_Delete_Grade_Api extends BaseTest {

    Grades_Collection gradecollection = new Grades_Collection();


    @Test(description = "Valid delete grades")
    @Description("test delee specific grade")
    @Story("delete grade")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("focus-case-1637098")
    @Issue("bug-tracker#1")
    public void Valid_Delete_exist_Grade() {

       Response delete_response = gradecollection.delete_grade(Token , "8");

    }
}