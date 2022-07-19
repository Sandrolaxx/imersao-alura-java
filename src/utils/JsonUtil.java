package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dto.ItemDto;

public class JsonUtil {

    public static List<ItemDto> parseJson(String json) {
        json = json.replace("{\"items\":[", "");
        json = json.replace("]", "");

        var listItem = new ArrayList<ItemDto>();

        while (getNextObject(json) != null) {
            var nextObject = getNextObject(json);
            var item = new ItemDto();

            /* TO DO implementar com reflection da classe */
            // for (Field field : itemDto.getClass().getDeclaredFields()) {
            item.setId(getObject("id", nextObject));
            item.setImDbRating(getObject("imDbRating", nextObject));
            item.setCrew(getObject("crew", nextObject));
            item.setFullTitle(getObject("fullTitle", nextObject));
            item.setImDbRatingCount(getObject("imDbRatingCount", nextObject));
            item.setImage(getObject("image", nextObject));
            item.setRank(getObject("rank", nextObject));
            item.setTitle(getObject("title", nextObject));
            item.setYear(getObject("year", nextObject));
            // }

            listItem.add(item);

            json = json.replace(nextObject, "");
        }

        return listItem;
    }

    private static String getNextObject(String json) {
        Pattern pattern = Pattern.compile("^\\{(.*?)\\},");
        Matcher matcher = pattern.matcher(json);

        while (matcher.find()) {
            return matcher.group();
        }

        return null;
    }

    private static String getObject(String fieldName, String jsonObject) {
        Pattern pattern = Pattern.compile("(\"".concat(fieldName).concat("\":)(\"(.*?)\")"));
        Matcher matcher = pattern.matcher(jsonObject);

        while (matcher.find()) {
            return matcher.group(3);
        }

        return null;
    }

}
