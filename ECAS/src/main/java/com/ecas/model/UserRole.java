package com.ecas.model;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@ToString
public class UserRole {
  private long  serial_number  ;
  private String  user_id;
  private String  role_id;
  private String  create_user;
  private String modify_user;
  private Date create_time ;
  private Date  modify_time ;
}
