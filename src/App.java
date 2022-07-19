import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

import dto.ItemDto;
import service.StickerService;
import utils.JsonUtil;

public class App {
    final static String BASE_URL = "https://mocki.io";
    final static String API_VERSION = "/v1/";
    final static String PATH_MOVIES = "67abcf2a-2cc4-4a9a-91e4-c1b65b61712c";

    private static String getUrl() {
        return BASE_URL.concat(API_VERSION).concat(PATH_MOVIES);
    }

    private static HttpRequest handleRequest(String path) {
        return HttpRequest.newBuilder(URI.create(path)).GET().build();
    }

    public static void main(String[] args) throws Exception {
        var restClient = HttpClient.newHttpClient();
        var httpRequestGet = handleRequest(getUrl());
        var stickerService = new StickerService();

        var response = restClient.send(httpRequestGet, BodyHandlers.ofString());
        var movieList = JsonUtil.parseJson(response.body());

        for (ItemDto itemDto : movieList) {
            var urlInputStream = new URL(itemDto.getImage()).openStream();
            var imgPath = "output/".concat(itemDto.getTitle()).concat(".png");

            stickerService.handleCreate(urlInputStream, imgPath, "TOP D++");

            System.out.println(itemDto.getFullTitle());
        }
    }
}
