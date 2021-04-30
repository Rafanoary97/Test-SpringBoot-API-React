package com.dani.monkeyd.app.appingen.repository;

import com.dani.monkeyd.app.appingen.models.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Cars,Long> {
}
