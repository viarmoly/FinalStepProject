package org.danit.luckyfit.dao;

import org.danit.luckyfit.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
