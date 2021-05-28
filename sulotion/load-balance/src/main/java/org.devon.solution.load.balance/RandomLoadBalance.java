package org.devon.solution.load.balance;

import org.devon.solution.load.balance.request.Request;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author devon.ye
 * @datetime 2019/12/14 11:47 PM
 * @since
 */
public class RandomLoadBalance implements LoadBalance {


    public String name() {
        return RandomLoadBalance.class.getSimpleName();
    }

    @Override
    public <T> T select(List<T> invokers, Request request) {
        if (invokers == null) return null;

        if (invokers.size() == 1) {
            return invokers.get(0);
        }

        ThreadLocalRandom random = ThreadLocalRandom.current();
        int serverNum = random.nextInt(invokers.size());// 获取一个随机数，拼装Channel的逻辑名称
        return invokers.get(serverNum);
    }


}
