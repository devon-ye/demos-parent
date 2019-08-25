/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.devon.design.pattern.template.methods;

import org.devon.design.pattern.template.methods.Tea;
import org.junit.Test;

/**
 * @author dewen.ye
 * @date 2019/2/17 01:17
 */
public class TeaTest {

    @Test
    public void brew() {
        Tea tea = new Tea();
        tea.brew();
    }

    @Test
    public void addCondiments() {
        Tea tea = new Tea();
        tea.brew();
        tea.addCondiments();
    }

    @Test
    public void isCustomerAddCondiments() {
        Tea tea = new Tea();
        tea.brew();
        tea.addCondiments();
        tea.isCustomerAddCondiments();
    }

    @Test
    public void prepareBeverrageTemplate() {
        Tea tea = new Tea();
        tea.brew();
        tea.addCondiments();
        tea.isCustomerAddCondiments();
        tea.prepareBeverrageTemplate();
    }
}