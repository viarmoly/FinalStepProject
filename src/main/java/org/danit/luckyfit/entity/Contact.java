package org.danit.luckyfit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;


@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "contact")
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
}
