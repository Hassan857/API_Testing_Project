package apis;

import com.shaft.api.RestActions;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class Login {

    public String baseURI = "https://backend.shifters.tech/api";
    RestActions apiObj = new RestActions(baseURI);
    private String login_endpoint = "/login";
    public String token ;





    public String  ValidLogin (String email, String password) {

        //Map<String, Object> formparams = new HashMap<String, Object>();
        JSONObject formparams = new JSONObject();
        formparams.put("email", email);
        formparams.put("password", password);
         Response response = apiObj.performRequest(RestActions.RequestType.POST , 200 , login_endpoint , formparams , ContentType.JSON);
       return  token = RestActions.getResponseJSONValue(response, "data.access_token");

    }


}
