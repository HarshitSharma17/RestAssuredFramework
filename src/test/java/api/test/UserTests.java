package api.test;

import api.endpoints.userEndpoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.fasterxml.jackson.annotation.JsonProperty;

import static api.endpoints.userEndpoints.readUser;

public class UserTests
{
    Faker faker;
    User payload;
    @BeforeClass
    public void setupData()
    {
    faker=new Faker();
    //making some random changes to make a new random commit through intellij insteead of iterm
    payload =new User();
    payload.setId(faker.idNumber().hashCode());
    payload.setUsername(faker.name().username());
    payload.setFirstName(faker.name().firstName());
    payload.setLastName(faker.name().lastName());
    payload.setEmail(faker.internet().safeEmailAddress());
    payload.setPassword(faker.internet().password(5,8));
    payload.setPhone(faker.phoneNumber().phoneNumber());
    }

    @Test
    public void TestPostUser()
    {
        System.out.println(payload);
        Response response= (Response) userEndpoints.createUSer(payload);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void getPostUser()
    {
       // System.out.println(payload);
        Response response= (Response) userEndpoints.createUSer(payload);

        Response response1=readUser(username);
        response1.then().log().all();
    }
}
