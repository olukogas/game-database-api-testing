package apis;
import io.restassured.RestAssured;
import org.testng.annotations.*;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class GameDetailsTest{

    @Test
    void test_GameDetails(){
        String game_details_url = String.format("https://api.rawg.io/api/games/portal?key=%s", ApiService.API_KEY);
        Response response = RestAssured.get(game_details_url);

        System.out.println(response.asString());
        System.out.println(response.getBody());
        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());


    }
}
