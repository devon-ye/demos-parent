package com.ecas.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserRole {
  private long  serial_number  ;
  private String  user_id;
  private String  role_id;
  private String  create_user;
  private String modify_user;
  private Date create_time ;
  private Date  modify_time ;
}
