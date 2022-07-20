package service;

import java.util.List;
import java.util.Scanner;

import enums.EnumUserChoice;

public class MenuService {

    final static Scanner option = new Scanner(System.in);

    public EnumUserChoice showMenu() {
        var options = List.of(EnumUserChoice.values());
        var menuTitle = addBlankLeftPad("\u001b[38;5;214m \u001b[48;5;153m MENU \u001b[m \u2728", 66);

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
        return addBlankLeftPad("| [".concat(enumUserChoice.getKey()).concat("] ")
                .concat(enumUserChoice.getValue()), 42).concat(" |");
    }

    private String addBlankLeftPad(String campo, int tamanhoCampo) {
        if (campo == null) {
            return lpad(campo, " ", tamanhoCampo);
        }
        if (campo.length() > tamanhoCampo) {
            campo = campo.substring(0, tamanhoCampo);
        }
        return lpad(campo, " ", tamanhoCampo);
    }

    private String lpad(String valueToPad, String filler, int size) {

        if (valueToPad == null) {
            valueToPad = "";
        }
        if (valueToPad.length() >= size) {
            valueToPad = valueToPad.substring(0, size);
        }

        while (valueToPad.length() < size) {
            valueToPad = valueToPad + filler;
        }
        return valueToPad;
    }

}
