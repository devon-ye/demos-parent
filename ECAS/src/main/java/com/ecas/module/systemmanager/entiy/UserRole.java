package com.ecas.module.systemmanager.entiy;

import com.ecas.common.base.entiy.BaseEntiy;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRole extends BaseEntiy{


  private static final long serialVersionUID = 3870532028866856531L;
  private String  userId;
  private String  roleId;

}
