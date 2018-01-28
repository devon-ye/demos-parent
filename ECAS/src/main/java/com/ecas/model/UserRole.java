package com.ecas.model;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@ToString
public class UserRole {
  private long serialNo;
  private String  userId;
  private String  roleId;

}
