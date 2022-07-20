package pattern;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import dto.ItemDto;
import utils.JsonUtil;

public class RestClient {
    
    final static String BASE_URL = "https://mocki.io";
    final static String API_VERSION = "/v1/";
    final static String PATH_MOVIES = "31f67bc7-2e21-406d-bcd0-4bd49369fd30";
    final static String PATH_SERIES = "01949919-1500-4617-8ba6-e3470e7eafe7";

    final static HttpClient restClient = HttpClient.newHttpClient();

    private static String getMoviesUrl() {
        return BASE_URL.concat(API_VERSION).concat(PATH_MOVIES);
    }

    private static String getSeriesUrl() {
        return BASE_URL.concat(API_VERSION).concat(PATH_SERIES);
    }

    private static HttpRequest handleRequest(String path) {
        return HttpRequest.newBuilder(URI.create(path)).GET().build();
    }

    public static List<ItemDto> fetchMovies() throws Exception {
        try {
            var response =  restClient.send(handleRequest(getMoviesUrl()), BodyHandlers.ofString()).body();

            
            return JsonUtil.parseJson(response);
        } catch (IOException | InterruptedException e) {
            throw new Exception("Erro ao buscar melhores filmes!");
        }
    }

    public static List<ItemDto> fetchSeries() throws Exception {
        try {
            var response =  restClient.send(handleRequest(getSeriesUrl()), BodyHandlers.ofString()).body();

            return JsonUtil.parseJson(response);
        } catch (IOException | InterruptedException e) {
            throw new Exception("Erro ao buscar melhores séries!");
        }
    }

}
