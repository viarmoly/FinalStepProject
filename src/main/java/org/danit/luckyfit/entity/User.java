package org.danit.luckyfit.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

@Data
@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue
  @Column(name = "user_id")
  private int userId;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "user_password")
  private String password;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_role_id")
  private UserRole userRole;

  @Column(name = "user_salt")
  String userSalt;
}
