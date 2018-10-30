package org.danit.luckyfit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue
  @Column(name = "user_id")
  private long userId;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "user_password")
  private String password;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "user_role_id")
  private UserRole userRole;

  @Column(name = "user_salt")
  String userSalt;
}
