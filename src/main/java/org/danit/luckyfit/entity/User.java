package org.danit.luckyfit.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id", unique = true, nullable = false)
  private long userId;

  @NonNull
  @Column(name = "user_name")
  private String userName;

  @NonNull
  @Column(name = "user_password")
  private String password;

  @ManyToOne
  @JsonManagedReference(value = "userRole")
  @JoinColumn(name = "user_role_id")
  private UserRole userRole;

  @NonNull
  @Column(name = "user_salt")
  private String userSalt;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonBackReference(value = "leads")
  @ToString.Exclude
  private List<Lead> leads;
}
