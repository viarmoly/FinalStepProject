package org.danit.luckyfit.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "contact")
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

  @Id
  @GeneratedValue
  @Column(name = "contact_id")
  private long id;

  @Column(name = "contact_phone")
  private String phone;

  @Column(name = "contact_name")
  private String name;

  @Column(name = "contact_email")
  private String email;

  @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonBackReference
  @ToString.Exclude
  private List<Lead> leads;
}
