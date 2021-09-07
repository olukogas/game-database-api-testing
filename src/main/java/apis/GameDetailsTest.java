package apis;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.*;
import io.restassured.response.*;


public class GameDetailsTest{

    @Test
    void test_GameDetails_Ok(){
        String gameDetailsUrl = String.format("https://api.rawg.io/api/games/portal?key=%s", ApiService.API_KEY);
        Response response = RestAssured.get(gameDetailsUrl);

        Assert.assertEquals(response.getStatusCode(), 200);

        String gameName = response.jsonPath().getString("name");
        Assert.assertEquals(gameName, "Portal");

        String responseBody = response.asString();
        Assert.assertTrue(responseBody.contains("puzzle"));

        System.out.println("Response Code: "+response.getStatusCode());
        System.out.println("Response Body: "+response.asPrettyString());
        System.out.println("Response Time: "+response.getTime()+"ms");



    }

    @Test
    void test_GameDetails_Not_Found(){
        String gameDetailsUrl = String.format("https://api.rawg.io/api/games/abc123?key=%s", ApiService.API_KEY);
        Response response = RestAssured.get(gameDetailsUrl);

        Assert.assertEquals(response.getStatusCode(), 404);

        String responseBody = response.asString();
        Assert.assertTrue(responseBody.contains("Not found"));

        System.out.println("Response Code: "+response.getStatusCode());
        System.out.println("Response body: "+response.asPrettyString());
        System.out.println("Response time: "+response.getTime()+" ms");

    }
}