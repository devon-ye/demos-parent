package org.devon.solution.distributed.tracing;

import java.util.UUID;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/6/5 00:14
 */
public class IdGenerator {


    public static String generatorTraceId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
