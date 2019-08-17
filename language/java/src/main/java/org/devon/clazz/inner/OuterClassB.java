package org.devon.clazz.inner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OuterClassB {
    private static Logger LOG = LoggerFactory.getLogger(OuterClassB.class);

    public void methodB() {
        LOG.info("OuterClassB.methodB()");
    }
}
