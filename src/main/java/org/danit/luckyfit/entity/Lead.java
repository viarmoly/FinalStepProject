package org.danit.luckyfit.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "lead")
@Data
public class  Lead {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "lead_id")
  private long id;

  @Column(name = "lead_name")
  private String name;

  @Column(name = "lead_creation_time")
  private Timestamp creationTime;

  @Column(name = "lead_comments")
  private String comments;

  @ManyToOne
  @JoinColumn(name = "lead_contact_id")
  @JsonManagedReference
  private Contact contact;

  @ManyToOne
  @JoinColumn(name = "lead_user_id")
  @JsonManagedReference(value = "leads")
  private User user;

  @ManyToOne
  @JoinColumn(name = "lead_product_id")
  @JsonManagedReference
  private Product product;

  @ManyToOne
  @JoinColumn(name = "lead_status_id")
  @JsonManagedReference
  private Status status;
}
