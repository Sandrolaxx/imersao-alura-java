package service;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import dto.ItemDto;
import enums.EnumUserChoice;
import utils.StringUtil;

public class MenuService {

    final static Scanner option = new Scanner(System.in);
    final static Scanner userRate = new Scanner(System.in);

    public EnumUserChoice showMenu() {
        var options = List.of(EnumUserChoice.values());
        var menuTitle = StringUtil.addBlankLeftPad("\u001b[38;5;214m \u001b[48;5;153m MENU \u001b[m \u2728", 66);

        System.out.println("\n|------------------------------------------|");
        System.out.println("|".concat(menuTitle).concat("|"));
        System.out.println("|------------------------------------------|");

        options.forEach(element -> System.out.println(getOptionTemplate(element)));

        System.out.println("|------------------------------------------|");
        var enumOption = EnumUserChoice.parseByKey(String.valueOf(option.next().charAt(0)));

        if (enumOption == null) {
            System.out.println("\n|------------------------------------------|");
            System.out.println("|             OPÇÃO INVÁLIDA!              |");
            System.out.println("|------------------------------------------|");

            showMenu();
        }

        return enumOption;
    }

    private String getOptionTemplate(EnumUserChoice enumUserChoice) {
        return StringUtil.addBlankLeftPad("| [".concat(enumUserChoice.getKey()).concat("] ")
                .concat(enumUserChoice.getValue()), 42).concat(" |");
    }

    public void resolveUserChoice(EnumUserChoice userOption, List<ItemDto> moviesList,
            List<ItemDto> seriesList) throws IOException {
        var stickerService = new StickerService();

        while (!userOption.equals(EnumUserChoice.EXIT)) {

            switch (userOption) {
                case SHOW_BEST_MOVIES:
                    System.out.println("Lista Melhores Filmes \u2728");

                    moviesList.forEach(ItemDto::printData);
                    handleUserVote(moviesList);

                    break;
                case SHOW_BEST_SERIES:
                    System.out.println("Lista Melhores Séries \uD83D\uDD25");

                    seriesList.forEach(ItemDto::printData);
                    handleUserVote(moviesList);

                    break;
                case GENERATE_STIKERS_BEST_MOVIES:
                    stickerService.generateSticker(moviesList, true);
                    break;
                case GENERATE_STIKERS_BEST_SERIES:
                    stickerService.generateSticker(seriesList, false);
                    break;
                case EXIT:
                    break;
            }

            userOption = showMenu();
        }

        System.out.println("Obrigado por usar nossa aplicação! \uD83D\uDE4F");
    }

    private List<ItemDto> handleUserVote(List<ItemDto> itemsList) {

        System.out.println("\nDeseja votar em um filme? [S/N]");
        var isVote = option.next().charAt(0);
        
        if (isVote == 'S') {
            for (int i = 0; i < itemsList.size(); i++) {
                System.out.println("[".concat(String.valueOf(i+1).concat("] - ").concat(itemsList.get(i).getTitle())));
            }
            
            System.out.println("\nDigite o número de uma das opções:");
            var rate =  userRate.next().charAt(0);

            try {
                var selectedItem = itemsList.get(Integer.valueOf(String.valueOf(rate)));

                if (selectedItem != null) {
                    itemsList.get(Integer.valueOf(String.valueOf(rate))).setUserVote(selectedItem.getUserVote() + 1);
                }

                System.out.println("\nObrigado por votar!");
            } catch (Exception e) {
                System.out.println("\nOpção inválida!");
            }

        } else if (isVote != 'N') {
            System.out.println("\nOpção inválida!");
        }

        return itemsList;
    }

}
