package com.ecas.common.captcha;

import java.awt.image.BufferedImage;

/**
 * Created by lenovo on 2017/12/27.
 */
public class CaptchaTest {

    private static String captcha="";

    public static void main(String[] args) {

            BufferedImage bufferedImage = new Captcha() {
                @Override
                protected void setInCache(String captcha) {
                    CaptchaTest.captcha= captcha;
                }
            }.generateImage();

    }
}
