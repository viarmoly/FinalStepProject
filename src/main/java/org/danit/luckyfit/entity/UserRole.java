package org.danit.luckyfit.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GenerationType;

@Data
@Entity
@Table(name = "user_role")

public class UserRole {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_role_id")
  private int id;

  @Column(name = "user_role_name")
  private String role;
}
