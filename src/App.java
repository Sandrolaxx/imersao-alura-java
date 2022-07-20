import enums.EnumUserChoice;
import pattern.RestClient;
import service.MenuService;
import service.StickerService;

public class App {

    public static void main(String[] args) throws Exception {
        var stickerService = new StickerService();
        var menuService = new MenuService();
        var userOption = EnumUserChoice.SHOW_BEST_MOVIES;
        
        var moviesList = RestClient.fetchMovies();
        var seriesList = RestClient.fetchSeries();

        try {
            while (!userOption.equals(EnumUserChoice.EXIT)) {
                userOption = menuService.showMenu();

                switch (userOption) {
                    case SHOW_BEST_MOVIES:
                        System.out.println("Lista Melhores Filmes \u2728\n");

                        moviesList.forEach(item -> System.out.println(item.getFullTitle()));
                        break;
                    case SHOW_BEST_SERIES:
                        System.out.println("Lista Melhores Séries \uD83D\uDD25\n");

                        seriesList.forEach(item -> System.out.println(item.getFullTitle()));
                        break;
                    case GENERATE_STIKERS_BEST_MOVIES:
                        stickerService.generateSticker(moviesList, true);
                        break;
                    case GENERATE_STIKERS_BEST_SERIES:
                        stickerService.generateSticker(seriesList, false);
                        break;
                    case EXIT:
                        System.out.println("Obrigado por usar nossa aplicação! \uD83D\uDE4F");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
