package org.danit.luckyfit.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_role")

public class UserRole {
  @Id
  @GeneratedValue
  private int id;

  @OneToMany
  private String role;

  public UserRole(int id, String role) {
    this.id = id;
    this.role = role;
  }
}
