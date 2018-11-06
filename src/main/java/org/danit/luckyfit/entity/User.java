package org.danit.luckyfit.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

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

  @ManyToOne
  @JsonManagedReference
  @JoinColumn(name = "user_role_id")
  private UserRole userRole;

  @Column(name = "user_salt")
  private String userSalt;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonBackReference
  @ToString.Exclude
  private List<Lead> leads;
}
