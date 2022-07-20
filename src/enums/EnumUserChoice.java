package enums;

public enum EnumUserChoice {

    SHOW_BEST_MOVIES("1", "Mostrar Melhores Filmes \uD83D\uDE0E"),
    SHOW_BEST_SERIES("2", "Mostrar Melhores Séries \uD83D\uDD1D"),
    GENERATE_STIKERS_BEST_MOVIES("3", "Gerar Figurinhas Melhores Filmes \uD83D\uDC81"),
    GENERATE_STIKERS_BEST_SERIES("4", "Gerar Figurinhas Melhores Séries \uD83D\uDCAB"),
    EXIT("5", "Sair \uD83C\uDFC3");

    private final String key, value;

    private EnumUserChoice(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static EnumUserChoice parseByKey(String key) {

        if (key != null && !key.trim().isEmpty()) {
            for (var value : EnumUserChoice.values()) {
                if (value.getKey().equalsIgnoreCase(key)) {
                    return value;
                }
            }
        }

        return null;
    }

}
