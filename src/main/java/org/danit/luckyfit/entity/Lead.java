package org.danit.luckyfit.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.sql.Timestamp;

@Entity
@Table(name = "lead")
@Data
public class Lead {
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

  @Column(name = "lead_product_id")
  private int productId;
}
