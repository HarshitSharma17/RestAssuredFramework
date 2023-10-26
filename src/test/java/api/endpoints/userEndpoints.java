package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

//created to perform create,update, delete requests for API
public class userEndpoints {

    public static User createUSer(User payload)
    {
        return (User) given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_url)
                .then().log().all();


    }

    public static Response readUser(String username)
    {

        return (Response) given().pathParam("username",username)
                .accept(ContentType.JSON)
                .when()
                .get(Routes.get_url)
                .then()
                .log().all();
    }

    public static Response updateUser(String username, User payload)
    {
        Response response = given().pathParam("username",username)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .put(Routes.update_url);

        return response;
    }

    public static Response getUser(String username)
    {
        Response response = given().pathParam("username",username)
                .accept(ContentType.JSON)
                .when()
                .delete(Routes.delete_url);

        return response;
    }
}
