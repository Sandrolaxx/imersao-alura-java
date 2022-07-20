package service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import dto.ItemDto;

public class StickerService {

    private void handleCreate(final InputStream inputStream, final String filePath,
            final String phrase) throws IOException {

        var originalImg = ImageIO.read(inputStream);

        int width = originalImg.getWidth();
        int height = originalImg.getHeight();
        int newHeight = height + 200;

        var newImg = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        var graphics2D = (Graphics2D) newImg.getGraphics();

        graphics2D.drawImage(originalImg, 0, 0, null);

        graphics2D.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        graphics2D.setColor(Color.CYAN);
        graphics2D.drawString(phrase, 0, newHeight - 120);

        var file = new File(filePath);

        if (!file.exists()) {
            file.mkdirs();
        }

        ImageIO.write(newImg, "png", file);

    }

    public void generateSticker(List<ItemDto> itemList, boolean isMoviesSticker) throws IOException {
        var folderPath = isMoviesSticker ? "movies/" : "series/";

        System.out.println("Gerando stickers............\uD83D\uDE38\n");

        for (ItemDto itemDto : itemList) {
            var urlInputStream = new URL(itemDto.getImage()).openStream();
            var imgPath = "output/".concat(folderPath).concat(itemDto.getTitle()).concat(".png");

            handleCreate(urlInputStream, imgPath, "TOP ++");

            System.out.println(itemDto.getFullTitle().concat("..........Gerado com sucesso sticker!\uD83C\uDFAF"));
        }

    }

}
