package apis;
import io.restassured.RestAssured;
import org.testng.annotations.*;

public class GameSeriesTest {
    @Test(description = "Checks for a 200 response to the GET /game-series endpoint")
    void test_GameSeries_Ok(){
        String gameSeriesUrl = String.format("https://api.rawg.io/api/games/Portal/game-series?key=%s", ApiService.API_KEY);
        RestAssured.given().get(gameSeriesUrl).then().statusCode(200).log();
    }

    @Test(description = "Checks for a 404 response to the GET /game-series endpoint")
    void test_GameSeries_Not_Found(){
        String gameSeriesUrl = String.format("https://api.rawg.io/api/games/kingdom_hearts/game-series?key=%s", ApiService.API_KEY);
        RestAssured.given().when().get(gameSeriesUrl).then().statusCode(404).log();
    }
}
