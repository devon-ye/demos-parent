package org.devon.solution.load.balance.request;

import java.io.Serializable;

/**
 * @author: devon.ye@foxmail.com
 * @datetime: 2021/5/28 13:25
 */
public interface Request extends Serializable {

    String serverUniqueName();

    Object[]  args();
}
