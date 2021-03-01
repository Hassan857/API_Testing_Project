package apis;

import com.shaft.api.RestActions;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class Grades_Collection extends Login  {

    JSONObject formparams = new JSONObject();
    String id;
    private String create_grade_end_point = "/grades/store";
    private String edit_grade_end_point = "/grades/update/";
    private String delete_grade_end_point = "/grades/destroy/";
    private String get_all_grades_end_point = "/getGrades";
    private String downlaod_grade_temp_end_point = "/school/getTemplateLink";



    public  Response create_grade(String grade_name, String short_name , String access_token) {

        formparams.put("grade_name" , grade_name);
        formparams.put("short_name" , short_name);

        return apiObj.buildNewRequest(create_grade_end_point , RestActions.RequestType.POST).addHeader("Authorization","Bearer "+ access_token)
                .setTargetStatusCode(200)
                .setRequestBody(formparams)
                .setContentType(ContentType.JSON).performRequest();
    }
    public  String create_grade_return_ID (String grade_name, String short_name , String access_token) {

        formparams.put("grade_name" , grade_name);
        formparams.put("short_name" , short_name);

         Response response  = apiObj.buildNewRequest(create_grade_end_point , RestActions.RequestType.POST).addHeader("Authorization","Bearer "+ access_token)
                .setTargetStatusCode(200)
                .setRequestBody(formparams)
                .setContentType(ContentType.JSON).performRequest();
         return id = RestActions.getResponseJSONValue(response , "data.id");
    }
    public Response edit_grade (String grade_name, String short_name , String access_token , String id ) {

        formparams.put("grade_name" , grade_name);
        formparams.put("short_name" , short_name);

        return apiObj.buildNewRequest(edit_grade_end_point+id , RestActions.RequestType.POST).addHeader("Authorization","Bearer "+ access_token)
                .setTargetStatusCode(200)
                .setRequestBody(formparams)
                .setContentType(ContentType.JSON).performRequest();
    }
    public Response get_grades (String access_token) {

        return apiObj.buildNewRequest(get_all_grades_end_point , RestActions.RequestType.GET).addHeader("Authorization","Bearer "+ access_token)
                .setTargetStatusCode(200)
                .setContentType(ContentType.JSON).performRequest();
    }
    public Response get_grade_template (String access_token) {

        return apiObj.buildNewRequest(downlaod_grade_temp_end_point , RestActions.RequestType.GET).addHeader("Authorization","Bearer "+ access_token)
                .setTargetStatusCode(200)
                .setContentType(ContentType.JSON).performRequest();
    }
    public Response delete_grade (String access_token , String id) {

        return apiObj.buildNewRequest(delete_grade_end_point+id, RestActions.RequestType.GET).addHeader("Authorization","Bearer "+ access_token)
                .setTargetStatusCode(200)
                .setContentType(ContentType.JSON).performRequest();
    }
}