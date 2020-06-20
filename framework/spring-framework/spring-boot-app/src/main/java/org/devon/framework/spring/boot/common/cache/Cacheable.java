package org.devon.framework.spring.boot.common.cache;

import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

/**
 * @author devon.ye@foxmail.com
 * @datetime 2020/5/11 4:17 PM
 * @description
 */
public interface Cacheable {

    String key();

    default String key(Object key) {
        if (key instanceof String) {
            return key.toString();
        } else if (key instanceof Integer) {
            return key.toString();
        }

        return null;
    }
}
