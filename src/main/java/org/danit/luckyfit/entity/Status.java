package org.danit.luckyfit.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "status")
public class Status {

  @Id
  @GeneratedValue
  @Column(name = "id_status")
  private int id;

  @NotNull
  @Column(name = "name_status")
  private String name;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Status{"
            +
            "id=" + id
            +
            ", name='" + name + '\''
            +
            '}';
  }
}
