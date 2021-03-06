package org.devon.design.pattern.chain.responsibility;

import org.junit.Test;

import java.util.Random;

/**
 * @author Devonmusa
 * @Describetion
 * @date 2017年3月1日
 */
public class ClientTest {

    private Handler handler;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void requestDiscount(float discount) {
        handler.processDiscount(discount);
    }

    @Test
    public void test() {
        System.out.println("Sales > 0.8 \t 0.6 < TeamLeader <= 0.8 \t  0.4 < Maneger <=0.6 \t Ceo <= 0.4");
        Random random = new Random();
        ClientTest client = new ClientTest();
        client.setHandler(HandlerFactory.createHandler());
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + "  ");
            client.requestDiscount(random.nextFloat());
        }
    }

}
