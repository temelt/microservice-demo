package com.temelt.inventory.service;

import com.temelt.inventory.entity.Inventory;
import com.temelt.inventory.repo.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by temelt on 28.01.2019.
 */
@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional
    public Inventory create(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Optional<Inventory> getById(Long id) {
        return inventoryRepository.findById(id);
    }

    public List<Inventory> getAll() {
        return inventoryRepository.findAll();
    }

    @Transactional
    public void update(Inventory inventory) {
        inventoryRepository.save(inventory);
    }
}
