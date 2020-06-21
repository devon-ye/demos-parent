package org.devon.spring.bean.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by lenovo on 2017/12/5.
 */
public class BeanLifeCycleImplnterface implements InitializingBean,DisposableBean{



    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(" bean start!!!");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(" bean stop");
    }
}
