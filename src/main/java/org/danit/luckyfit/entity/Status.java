package org.danit.luckyfit.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.danit.luckyfit.StatusDeserializer;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(using = StatusDeserializer.class)
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "status")
public class Status {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "status_id", unique = true, nullable = false)
  private long id;

  @NonNull
  @Column(name = "status_name")
  private String name;

  @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonBackReference
  @ToString.Exclude
  private List<Lead> leads;
}
