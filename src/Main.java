import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String appelInput = "C:\\Users\\Owner\\Downloads\\yes\\images.jpeg";
        String appelOutput = "C:\\Users\\Owner\\Downloads\\yes\\output.jpeg";

        String menInput = "C:\\Users\\Owner\\Downloads\\yes\\contentImage.jpeg";
        String menOutput = "C:\\Users\\Owner\\Downloads\\yes\\output1.jpeg";

        String noaInput = "C:\\Users\\Owner\\Downloads\\yes\\noa.jpg";
        String noaOutput = "C:\\Users\\Owner\\Downloads\\yes\\output3.jpg";

        String viewInput = "C:\\Users\\Owner\\Downloads\\yes\\View.jpg";
        String viewOutput = "C:\\Users\\Owner\\Downloads\\yes\\output4.jpg";





//        onlyBlackWhite(menInput,menOutput);
//        //grayscale(noaInput,noaOutput);
//        colorShiftRight(viewInput, viewOutput );
//        //colorShifLeft(noaInput, noaOutput);
//        Negative(appelInput,appelOutput );
//        Mirror(appelInput, appelOutput);
////        eliminateRed(appelInput,appelOutput);

////        addNoise(appelInput,appelOutput);
        //Vintage(noaInput,noaOutput);
        darker(appelInput, viewOutput);





    }



        public static void onlyBlackWhite(String pathInput, String puth0utput) {

        try {
            File file = new File(pathInput);
            if (file.exists()) {
                System.out.println("exists");
                BufferedImage bufferedImage = ImageIO.read(file);
                Color colorWhite = new Color(255, 255, 255);
                Color colorBlack = new Color(0, 0, 0);
                for (int y = 0; y < bufferedImage.getHeight(); y++) {
                    for (int x = 0; x < bufferedImage.getWidth(); x++) {
                        int currentColor = bufferedImage.getRGB(x, y);
                        Color colorPicture = new Color(currentColor);
                        if ((colorPicture.getGreen() + colorPicture.getRed() + colorPicture.getBlue()) / 3 > 122.5) {
                            bufferedImage.setRGB(x, y, colorWhite.getRGB());
                        } else {
                            bufferedImage.setRGB(x, y, colorBlack.getRGB());

                        }
                    }
                }
                File output1 = new File(puth0utput);
                ImageIO.write(bufferedImage, "jpeg", output1);
            } else {
                System.out.println("nop");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void grayscale(String pathInput, String puth0utput){
        try {
            File file = new File(pathInput);
            if (file.exists()) {
                System.out.println("exists");
                BufferedImage bufferedImage = ImageIO.read(file);

                for (int x = 0; x < bufferedImage.getWidth(); x++) {
                    for (int y = 0; y < bufferedImage.getHeight(); y++) {
                        int currentColor = bufferedImage.getRGB(x, y);
                        Color colorPicture = new Color(currentColor);
                        int average   = (colorPicture.getRed()+colorPicture.getGreen()+colorPicture.getBlue())/3;
                        Color colorAverage = new Color(average, average, average);
                            bufferedImage.setRGB(x,y, colorAverage.getRGB());
                        }
                    }
                File output3 = new File(puth0utput);
                ImageIO.write(bufferedImage, "jpeg", output3);
                }else{
                System.out.println("nop");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public static void colorShiftRight(String pathInput, String puth0utput){
        try {
            File file = new File(pathInput);
            if (file.exists()) {
                System.out.println("exists");
                BufferedImage bufferedImage = ImageIO.read(file);

                for (int x = 0; x < bufferedImage.getWidth(); x++) {
                    for (int y = 0; y < bufferedImage.getHeight(); y++) {
                        int currentColor = bufferedImage.getRGB(x, y);
                        Color colorPicture = new Color(currentColor);
                        Color colorShiftRight = new Color(
                                colorPicture.getGreen(),
                                colorPicture.getBlue(),
                                colorPicture.getRed());
                        bufferedImage.setRGB(x,y, colorShiftRight.getRGB());
                    }
                }
                File output3 = new File(puth0utput);
                ImageIO.write(bufferedImage, "jpeg", output3);
            }else{
                System.out.println("nop");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void colorShifLeft(String pathInput, String puth0utput){
        try {
            File file = new File(pathInput);
            if (file.exists()) {
                System.out.println("exists");
                BufferedImage bufferedImage = ImageIO.read(file);

                for (int x = 0; x < bufferedImage.getWidth(); x++) {
                    for (int y = 0; y < bufferedImage.getHeight(); y++) {
                        int currentColor = bufferedImage.getRGB(x, y);
                        Color colorPicture = new Color(currentColor);
                        Color colorShifLeft = new Color(
                                colorPicture.getBlue()
                                ,colorPicture.getRed()
                                ,colorPicture.getGreen()
                        );

                        bufferedImage.setRGB(x, y, colorShifLeft.getRGB());
                    }
                }
                File output3 = new File(puth0utput);
                ImageIO.write(bufferedImage, "jpeg", output3);
            } else {
                System.out.println("nop");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void Negative(String pathInput, String puth0utput){

        try {
            File file = new File(pathInput);
            if (file.exists()) {
                System.out.println("exists");
                BufferedImage bufferedImage = ImageIO.read(file);

                for (int x = 0; x < bufferedImage.getWidth(); x++) {
                    for (int y = 0; y < bufferedImage.getHeight(); y++) {
                        int currentColor = bufferedImage.getRGB(x, y);
                        Color colorPicture = new Color(currentColor);
                        Color negativeColor = new Color(
                                255 - colorPicture.getRed(),
                                255 - colorPicture.getGreen(),
                                255 - colorPicture.getBlue()
                        );

                        bufferedImage.setRGB(x, y, negativeColor.getRGB());
                    }
                }
                File output3 = new File(puth0utput);
                ImageIO.write(bufferedImage, "jpeg", output3);
            } else {
                System.out.println("nop");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void Mirror(String pathInput, String puth0utput){
        try {
            File file = new File(pathInput);
            if (file.exists()) {
                System.out.println("exists");
                BufferedImage bufferedImage = ImageIO.read(file);

                for (int x = 0; x < bufferedImage.getWidth()/2; x++) {
                    for (int y = 0; y < bufferedImage.getHeight(); y++) {
                        Color currentColor = new Color(bufferedImage.getRGB(x, y));
                        Color mirrorColor = new Color(bufferedImage.getRGB(bufferedImage.getWidth() -x -1,y ));
                        bufferedImage.setRGB(x, y, mirrorColor.getRGB());
                        bufferedImage.setRGB(bufferedImage.getWidth() -x -1, y, currentColor.getRGB() );


                    }
                }
                File output3 = new File(puth0utput);
                ImageIO.write(bufferedImage, "jpeg", output3);
            } else {
                System.out.println("nop");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void eliminateRed(String pathInput, String puth0utput){
        try {
            File file = new File(pathInput);
            if (file.exists()) {
                System.out.println("exists");
                BufferedImage bufferedImage = ImageIO.read(file);

                for (int x = 0; x < bufferedImage.getWidth(); x++) {
                    for (int y = 0; y < bufferedImage.getHeight(); y++) {
                        int currentColor = bufferedImage.getRGB(x, y);
                        Color colorPicture = new Color(currentColor);
                        Color eliminateRed = new Color(
                                0,
                                colorPicture.getGreen(),
                                colorPicture.getBlue()
                        );

                        bufferedImage.setRGB(x, y, eliminateRed.getRGB());
                    }
                }
                File output3 = new File(puth0utput);
                ImageIO.write(bufferedImage, "jpeg", output3);
            } else {
                System.out.println("nop");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }





    public static void addNoise (String pathInput, String puth0utput){
        try {
            File file = new File(pathInput);
            if (file.exists()) {
                System.out.println("exists");
                Random rand = new Random();
                BufferedImage bufferedImage = ImageIO.read(file);


                for (int x = 0; x < bufferedImage.getWidth(); x++) {
                    for (int y = 0; y < bufferedImage.getHeight(); y++) {
                        int currentColor = bufferedImage.getRGB(x, y);
                        Color colorPicture = new Color(currentColor);
                        int noiseR = Math.min(Math.max(colorPicture.getRed() + rand.nextInt(50) - 25, 0), 255);
                        int noiseG = Math.min(Math.max(colorPicture.getGreen() + rand.nextInt(51) - 25, 0), 255);
                        int noiseB = Math.min(Math.max(colorPicture.getBlue() + rand.nextInt(51) - 25, 0), 255);

                       Color noisyColor = new Color(noiseR, noiseG, noiseB);

                        bufferedImage.setRGB(x, y, noisyColor.getRGB());
                    }
                }
                File output3 = new File(puth0utput);
                ImageIO.write(bufferedImage, "jpeg", output3);
            } else {
                System.out.println("nop");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void Vintage(String pathInput, String puth0utput){
        try {
            File file = new File(pathInput);
            if (file.exists()) {
                System.out.println("exists");
                Random rand = new Random();
                BufferedImage bufferedImage = ImageIO.read(file);


                for (int x = 0; x < bufferedImage.getWidth(); x++) {
                    for (int y = 0; y < bufferedImage.getHeight(); y++) {
                        int currentColor = bufferedImage.getRGB(x, y);
                        Color colorPicture = new Color(currentColor);

                        int red = colorPicture.getRed();
                        int green = colorPicture.getGreen();
                        int blue = colorPicture.getBlue();
                        int avg = (red+green+blue)/3;
                        int depth = 20;
                        int intensity = 30;

                        red= avg+(depth*2);
                        green = avg+depth;
                        blue = avg-intensity;

                        if (red>255){
                            red = 255;
                        }
                        if (green>255){
                            green = 255;
                        }
                        if (blue>255){
                            blue = 255;
                        }
                        if (blue<255){
                            blue = 0;
                        }

                        Color sepiaColor = new Color(red,green,blue);
                        bufferedImage.setRGB(x, y,sepiaColor.getRGB());
                        int noiseR = Math.min(Math.max(red + rand.nextInt(50) - 25, 0), 255);
                        int noiseG = Math.min(Math.max(green + rand.nextInt(51) - 25, 0), 255);
                        int noiseB = Math.min(Math.max(blue+ rand.nextInt(51) - 25, 0), 255);

                        Color noisyColor = new Color(noiseR, noiseG, noiseB);

                        bufferedImage.setRGB(x, y, noisyColor.getRGB());
                    }
                }
                File output3 = new File(puth0utput);
                ImageIO.write(bufferedImage, "jpeg", output3);
            } else {
                System.out.println("nop");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }






        public static void darker(String pathInput, String puth0utput) {

            try {
                File file = new File(pathInput);
                if (file.exists()) {
                    System.out.println("exists");
                    BufferedImage bufferedImage = ImageIO.read(file);

                    for (int x = 0; x < bufferedImage.getWidth(); x++) {
                        for (int y = 0; y < bufferedImage.getHeight(); y++) {
                            int currentColor = bufferedImage.getRGB(x, y);
                            Color colorPicture = new Color(currentColor);
                            int red = colorPicture.getRed(), green = colorPicture.getGreen(), blue = colorPicture.getBlue();
                            Color darkerColor = new Color((int) (red * 0.6667), (int) (green * 0.6667), (int) (blue * 0.6667));
                            bufferedImage.setRGB(x, y, darkerColor.getRGB());


                        }
                    }
                    File output3 = new File(puth0utput);
                    ImageIO.write(bufferedImage, "jpeg", output3);
                } else {
                    System.out.println("nop");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

    }





