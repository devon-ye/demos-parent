package com.bean;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/11/26.
 */
public class Province implements Serializable {

    private final static long serialVersionUID = 1L;
    private int provinceId;
    private String provinceName;
    private int zooArea;
    private int avgEcnomic;

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getZooArea() {
        return zooArea;
    }

    public void setZooArea(int zooArea) {
        this.zooArea = zooArea;
    }

    public int getAvgEcnomic() {
        return avgEcnomic;
    }

    public void setAvgEcnomic(int avgEcnomic) {
        this.avgEcnomic = avgEcnomic;
    }
}
