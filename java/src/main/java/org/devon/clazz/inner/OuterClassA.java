package org.devon.clazz.inner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OuterClassA {

    private static Logger LOG = LoggerFactory.getLogger(OuterClassB.class);

    public void methodA() {
        LOG.info("OuterClassA.methodA()");
    }
}
