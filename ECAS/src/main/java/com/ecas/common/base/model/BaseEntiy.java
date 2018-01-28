package com.ecas.common.base.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author devon
 * @version V1.0
 * @Description: TODO
 * @date ${date} ${time}
 */
@Data
@ToString
public class BaseEntiy implements Serializable {
    
    /**
    *  主键　序列号
    */
    private long serialNo;
    /**
    *创建时间
    */
    private long createTime;
    /**
    *创建者ｉｄ
    */
    private long createId;
    /**
     *创建者名称
     */
    private String createName;
    /**
    *修改时间
    */
    private long updateTime;
    /**
    *修改者ＩＤ
    */
    private long  updateId;
    /**
     *修改者名称
     */
    private String updateName;


}
