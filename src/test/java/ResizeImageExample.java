import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResizeImageExample {

    public static void main(String... args) throws IOException {

        File input = new File("D:/poiexcel/sai.jpg");
        BufferedImage image = ImageIO.read(input);

        BufferedImage resized = resize(image, 200, 200);

        File output = new File("D:/poiexcel/sai_compress.jpg");
        ImageIO.write(resized, "jpg", output);

    }

    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.SCALE_DEFAULT);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }

}