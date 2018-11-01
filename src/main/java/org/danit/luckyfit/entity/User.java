package org.danit.luckyfit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Data
@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

  @Id
  @GeneratedValue
  @Column(name = "user_id")
  private long userId;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "user_password")
  private String password;

  @ManyToOne
  @JsonManagedReference
  @JoinColumn(name = "user_role_id")
  private UserRole userRole;

  @Column(name = "user_salt")
  String userSalt;
}
