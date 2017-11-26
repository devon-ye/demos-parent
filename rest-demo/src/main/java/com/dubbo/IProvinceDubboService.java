package com.dubbo;

import com.bean.Province;

/**
 * Created by lenovo on 2017/11/26.
 */
public interface IProvinceDubboService {

    Province getProviceName(String provinceName);
}
