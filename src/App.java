import pattern.RestClient;
import service.MenuService;

public class App {

    public static void main(String[] args) throws Exception {
        var menuService = new MenuService();

        try {
            var moviesList = RestClient.fetchMovies();
            var seriesList = RestClient.fetchSeries();

            var userOption = menuService.showMenu();

            menuService.resolveUserChoice(userOption, moviesList, seriesList);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
