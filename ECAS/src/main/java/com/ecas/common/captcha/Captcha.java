package com.ecas.common.captcha;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by lenovo on 2017/12/27.
 */
public abstract class Captcha {
    private Random random = new Random();
    private String randString = "023456789ABCDEFGHJKLMNPQRSTUVWXYZ";// 随机产生的字符串

    private int width = 30;
    private int height = 15;
    private int charSize = 4;
    private int lineSize = 20;
    private int fontSize = 18;
    private String fontStyle = "Fixedsys";


    public BufferedImage generateImage() {
        return this.generateImage(width, height);
    }

    public BufferedImage generateImage(int width, int height) {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(getRandColor(random.nextInt(254), random.nextInt(254)));
        graphics.setFont(getFont());
        // 绘制干扰线
        for (int i = 0; i <= lineSize; i++) {
            drowLine(graphics);
        }
        // 绘制随机字符
        String randomString = "";
        for (int i = 1; i <= charSize; i++) {
            randomString = drowString(graphics, randomString, i);
        }
        setInCache(randomString);
        graphics.dispose();
        return bufferedImage;
    }

    private Font getFont() {
        return new Font(fontStyle, Font.CENTER_BASELINE, fontSize);
    }

    private Color getRandColor(int fc, int bc) {
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }

        if (fc > bc) {
            int temp = fc;
            fc = bc;
            bc = temp;
        }
        int r = fc + random.nextInt(bc - fc - 16);
        int g = fc + random.nextInt(bc - fc - 14);
        int b = fc + random.nextInt(bc - fc - 18);
        return new Color(r, g, b);
    }

    protected abstract void setInCache(String captcha);

    /*
     * 绘制字符串
     */
    private String drowString(Graphics g, String randomString, int i) {
        g.setFont(getFont());
        g.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
        String rand = String.valueOf(getRandomString(random.nextInt(randString.length())));
        randomString += rand;
        g.translate(random.nextInt(3), random.nextInt(3));
        g.drawString(rand, 13 * i, 20);
        return randomString;
    }

    /*
     * 绘制干扰线
     */
    private void drowLine(Graphics g) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(13);
        int yl = random.nextInt(15);
        g.drawLine(x, y, x + xl, y + yl);
    }

    /*
     * 获取随机的字符
     */
    public String getRandomString(int num) {
        return String.valueOf(randString.charAt(num));
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCharSize() {
        return charSize;
    }

    public void setCharSize(int charSize) {
        this.charSize = charSize;
    }

    public int getLineSize() {
        return lineSize;
    }

    public void setLineSize(int lineSize) {
        this.lineSize = lineSize;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }


}
