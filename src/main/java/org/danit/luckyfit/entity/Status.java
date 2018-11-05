package org.danit.luckyfit.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@Table(name = "status")
public class Status {

  @Id
  @GeneratedValue
  @Column(name = "status_id")
  private long id;

  @NotNull
  @Column(name = "status_name")
  private String name;

  @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonBackReference
  @ToString.Exclude
  private List<Lead> leads;
}
