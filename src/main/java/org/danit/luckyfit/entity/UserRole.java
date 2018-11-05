package org.danit.luckyfit.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import java.util.List;

@Data
@Entity
@Table(name = "user_role")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserRole {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_role_id")
  private int id;

  @Column(name = "user_role_name")
  private String role;

  @JsonBackReference
  @OneToMany(mappedBy = "userRole", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
  @ToString.Exclude
  List<User> users;
}
