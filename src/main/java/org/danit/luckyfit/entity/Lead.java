package org.danit.luckyfit.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
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

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "product_id")
  private Product product;
}
