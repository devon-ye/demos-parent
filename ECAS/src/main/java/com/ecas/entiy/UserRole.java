package com.ecas.entiy;

import com.ecas.common.base.model.BaseEntiy;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@ToString
public class UserRole extends BaseEntiy{


  private static final long serialVersionUID = 3870532028866856531L;
  private String  userId;
  private String  roleId;

}
