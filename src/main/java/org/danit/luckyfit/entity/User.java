package org.danit.luckyfit.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.util.List;

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

  @Column(name = "user_role_id")
  private int userRoleId;

  @Column(name = "user_salt")
  String userSalt;

//  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//  @JoinColumn(name = "contact_id")
//  private List<Contact> contacts;
}
