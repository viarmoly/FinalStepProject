package org.danit.luckyfit.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Data
@Entity
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue
  @Column(name = "product_id")
  private int productId;

  @Column(name = "product_name")
  private String productName;
}
