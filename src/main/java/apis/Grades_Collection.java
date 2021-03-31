package apis;

import com.shaft.api.RestActions;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.List;

public class Grades_Collection extends Login {

    JSONObject formparams = new JSONObject();
    String id;
    private String create_grade_end_point = "/grades/store";
    private String edit_grade_end_point = "/grades/update/";
    private String delete_grade_end_point = "/grades/destroy/";
    private String get_all_grades_end_point = "/getGrades";
    private String downlaod_grade_temp_end_point = "/grades/getTemplateLink";
    private String import_grades_end_point = "/grades/importGrades";


    public Response create_grade(String grade_name, String short_name, String access_token) {

        formparams.put("grade_name", grade_name);
        formparams.put("short_name", short_name);

        return apiObj.buildNewRequest(create_grade_end_point, RestActions.RequestType.POST).addHeader("Authorization", "Bearer " + access_token)
                .setTargetStatusCode(200)
                .setRequestBody(formparams)
                .setContentType(ContentType.JSON).performRequest();

    }

    public String create_grade_return_ID(String grade_name, String short_name, String access_token) {

        formparams.put("grade_name", grade_name);
        formparams.put("short_name", short_name);

        Response response = apiObj.buildNewRequest(create_grade_end_point, RestActions.RequestType.POST).addHeader("Authorization", "Bearer " + access_token)
                .setTargetStatusCode(200)
                .setRequestBody(formparams)
                .setContentType(ContentType.JSON).performRequest();
        return id = RestActions.getResponseJSONValue(response, "data.id");
    }

    public Response edit_grade(String grade_name, String short_name, String access_token, String id) {

        formparams.put("grade_name", grade_name);
        formparams.put("short_name", short_name);

        return apiObj.buildNewRequest(edit_grade_end_point + id, RestActions.RequestType.POST).addHeader("Authorization", "Bearer " + access_token)
                .setTargetStatusCode(200)
                .setRequestBody(formparams)
                .setContentType(ContentType.JSON).performRequest();
    }

    public Response get_grades(String access_token) {

        return apiObj.buildNewRequest(get_all_grades_end_point, RestActions.RequestType.GET).addHeader("Authorization", "Bearer " + access_token)
                .setTargetStatusCode(200)
                .setContentType(ContentType.JSON).performRequest();
    }

    public Response get_grade_template(String access_token) {

        return apiObj.buildNewRequest(downlaod_grade_temp_end_point, RestActions.RequestType.GET).addHeader("Authorization", "Bearer " + access_token)
                .setTargetStatusCode(200)
                .setContentType(ContentType.JSON).performRequest();
    }

    public Response delete_grade(String access_token, String id) {

        return apiObj.buildNewRequest(delete_grade_end_point + id, RestActions.RequestType.DELETE).addHeader("Authorization", "Bearer " + access_token)
                .setTargetStatusCode(200)
                .setContentType(ContentType.JSON).performRequest();
    }

    public Response import_Grades(String access_token, String filename) {

        /*File f = new File(System.getProperty("user.dir")+"/downloads/"+filename);

        return apiObj.buildNewRequest(import_grades_end_point , RestActions.RequestType.POST).addHeader("Authorization","Bearer "+ access_token)
               .setTargetStatusCode(200)
                .setRequestBody(f)
        .setContentType(ContentType.fromContentType("multipart/form-data")).performRequest();*/
                File f = new File(System.getProperty("user.dir")+"/downloads/myfile.xlsx");

        return apiObj.performRequest(RestActions.RequestType.POST , 200 , import_grades_end_point ,
               f   , ContentType.HTML );

    }


    }
