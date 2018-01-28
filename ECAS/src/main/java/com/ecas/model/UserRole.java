package com.ecas.model;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@ToString
public class UserRole {
  private long serialNumber;
  private String  userＩd;
  private String  roleＩd;
  private String  createＵser;
  private String modifyUser;
  private Date createＴime ;
  private Date modifyTime;
}
