package pattern;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Optional;

import dto.ItemDto;
import utils.JsonUtil;

public class RestClient {

    final static String BASE_URL = "https://mocki.io";
    final static String API_VERSION = "/v1/";// Desafio 03 aula 1
    final static String PATH_MOVIES = Optional.ofNullable(System.getenv("PATH_MOVIES"))
            .orElseThrow(() -> new RuntimeException("PATH_MOVIES não foi setada no ambiente!"));
    final static String PATH_SERIES = Optional.ofNullable(System.getenv("PATH_SERIES"))
            .orElseThrow(() -> new RuntimeException("PATH_SERIES não foi setada no ambiente!"));

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
            var response = restClient.send(handleRequest(getMoviesUrl()), BodyHandlers.ofString()).body();

            return JsonUtil.parseJson(response);
        } catch (IOException | InterruptedException e) {
            throw new Exception("Erro ao buscar melhores filmes!");
        }
    }

    public static List<ItemDto> fetchSeries() throws Exception {
        try {
            var response = restClient.send(handleRequest(getSeriesUrl()), BodyHandlers.ofString()).body();

            return JsonUtil.parseJson(response);
        } catch (IOException | InterruptedException e) {
            throw new Exception("Erro ao buscar melhores séries!");
        }
    }

}
