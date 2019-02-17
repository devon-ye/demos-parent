/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.jvm;

import org.junit.Test;

/**
 * @author dewen.ye
 * @date 2019/2/16 20:01
 */
public class JvmStandarArgsTest {
    JvmStandarArgs jvmStandarArgs = new JvmStandarArgs();

    @Test
    public void getSystemEnv() {

        jvmStandarArgs.getSystemEnv();
    }

    @Test
    public void getSystemProperties() {
        jvmStandarArgs.getSystemProperties();
    }


}