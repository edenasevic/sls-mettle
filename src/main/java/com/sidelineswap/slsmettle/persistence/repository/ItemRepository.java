package com.sidelineswap.slsmettle.persistence.repository;

import com.sidelineswap.slsmettle.persistence.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, String> {
}
