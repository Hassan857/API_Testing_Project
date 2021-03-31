package tests;

import apis.Grades_Collection;
import apis.Login;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.io.File;


public class Test_Import_Grades_Api extends BaseTest {


    Login login = new Login();
    String baseURI = login.baseURI;
    private RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(baseURI)
            .log(LogDetail.ALL)
            .build();
    private ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.BODY)
            .build();

    Grades_Collection gradecollection = new Grades_Collection();


    @Test(description = "Valid Import Grades")
    @Description("when click import grades then choose the file and uploaded grades created ")
    @Story("import Grade")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("focus-case-1637098")
    @Issue("bug-tracker#1")
    public void import_grades () {


        //Response import_Grades_response = gradecollection.import_Grades(Token , "myfile.xlsx");

        Response res = RestAssured.given().relaxedHTTPSValidation().multiPart("file" , new File(System.getProperty("user.dir")+"/downloads/myfile.xlsx"))
                .header("Authorization", "Bearer " + Token).header("Content-Type" , "multipart/form-data").post("/grades/importGrades").then().extract().response();
    }
}
