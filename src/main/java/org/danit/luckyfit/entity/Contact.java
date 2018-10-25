package org.danit.luckyfit.entity;

import lombok.Data;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Data
@Table(name = "contact")
public class Contact {

  @Id
  @GeneratedValue
  @Column(name = "contact_id")
  private int id;

  @Column(name = "contact_phone")
  private String phone;

  @Column(name = "contact_name")
  private String name;

  @Column(name = "contact_email")
  private String email;
}
