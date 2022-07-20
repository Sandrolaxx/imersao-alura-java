package utils;

public class StringUtil {
    public static String addBlankLeftPad(String campo, int tamanhoCampo) {
        if (campo == null) {
            return lpad(campo, " ", tamanhoCampo);
        }
        if (campo.length() > tamanhoCampo) {
            campo = campo.substring(0, tamanhoCampo);
        }
        return lpad(campo, " ", tamanhoCampo);
    }

    public static String lpad(String valueToPad, String filler, int size) {

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

    public static String getStarRating(Double rate) {
        if (rate > 9.0d) {
            return "\u2B50\u2B50\u2B50\u2B50\u2B50";
        } else if (rate > 8.0d) {
            return "\u2B50\u2B50\u2B50\u2B50";
        } else if (rate > 6.0d) {
            return "\u2B50\u2B50\u2B50";
        } else if (rate > 4.0d) {
            return "\u2B50\u2B50";
        } else {
            return "\u2B50";
        }
    }
}
