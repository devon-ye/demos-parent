package org.devon.spring.bean.scope;

import org.devon.spring.SpringDemoApp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lenovo on 2017/12/5.
 */

public class BeanScopeTest extends SpringDemoApp{
    private static final String SPRING_CONFIG_FILE = "spring-beans-scope.xml";

    @Before
    public void setUp() {
        super.initApplicationContext(SPRING_CONFIG_FILE);

    }

    @Test
    public void testBeanScope() {
        BeanScope beanScope = super.getBean("beanScopeSingleton");
        beanScope.print();
        BeanScope beanScope1 = super.getBean("beanScopeSingleton");
        beanScope1.print();
        BeanScope beanScope2 = super.getBean("beanScopePrototype");
        beanScope2.print();
        BeanScope beanScope3 = super.getBean("beanScopePrototype");
        beanScope3.print();

    }

    @After
    public void after() {

    }

}
