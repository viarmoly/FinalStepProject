package org.danit.luckyfit.dao;

import org.danit.luckyfit.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
