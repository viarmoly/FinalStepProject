package org.danit.luckyfit.entity.dto;

import lombok.Data;

@Data
public class UserDto {
  private String userName;
  private String password;
  private String userSalt;
}
