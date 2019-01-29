package com.temelt.inventory.api;

import com.temelt.inventory.entity.Inventory;
import com.temelt.inventory.service.InventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by temelt on 28.01.2019.
 */
@RestController
@RequestMapping("/inventory")
@Api(value = "Inventory APIs")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Get Inventory By Id")
    public ResponseEntity<?> getById(@RequestParam(name = "id") Long id) {
        Optional<Inventory> inventory = inventoryService.getById(id);
        return inventory.isPresent() ? ResponseEntity.ok(inventory.get()): ResponseEntity.notFound().build();
    }

    @PostMapping
    @ApiOperation(value = "Create Inventory")
    public ResponseEntity<?> create(@RequestBody @Valid Inventory inventory) {
        inventory = inventoryService.create(inventory);
        return ResponseEntity.ok(inventory);
    }

    @GetMapping
    @ApiOperation(value = "Get All Inventories")
    public ResponseEntity<?> getAll() {
        List<Inventory> inventories = inventoryService.getAll();
        return ResponseEntity.ok(inventories);
    }

    @PutMapping
    @ApiOperation(value = "Update Inventory")
    public ResponseEntity<?> update(@RequestBody @Valid Inventory inventory) {
        inventoryService.update(inventory);
        return ResponseEntity.ok(true);
    }

}
