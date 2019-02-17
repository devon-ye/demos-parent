/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.enums.demo;

import org.junit.Test;

/**
 * @author dewen.ye
 * @date 2019/2/17 10:32
 */
public class BurritoTest {

    @Test
    public void describe() {
        Burrito plain = new Burrito(Spiciness.HOT);
        Burrito greeChile = new Burrito(Spiciness.MEDIU);
        Burrito jalapeno = new Burrito(Spiciness.HOT);
        plain.describe();
        greeChile.describe();
        jalapeno.describe();
    }
}