package com.temelt.inventory.repo;

import com.temelt.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by temelt on 28.01.2019.
 */
public interface InventoryRepository extends JpaRepository<Inventory,Long>{
}
