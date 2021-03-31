package tests;

import apis.Grades_Collection;
import com.shaft.validation.Assertions;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Update_Grade_Api extends BaseTest{

    Grades_Collection gradecollection = new Grades_Collection();
    String gradename , shortname , newgradename , newshortname;


    @Test(description = "Valid Update Grade")
    @Description("When I enter valid data in the create grade form And click the ok button, grade should be created")
    @Story("Create Grade")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("focus-case-1637098")
    @Issue("bug-tracker#1")

    public void valid_update_existing_grade () {

        newgradename = filereader.getCellData("updated grade_name");
        newshortname = filereader.getCellData("updated short_name");

        Response update_response = gradecollection.edit_grade(newgradename , newshortname , Token , "6");
        Assertions.assertTrue(update_response.getBody().asString().contains(newgradename));
        Assert.assertEquals(update_response.getBody().jsonPath().get("data.grade_name") , newgradename);

    }
}
