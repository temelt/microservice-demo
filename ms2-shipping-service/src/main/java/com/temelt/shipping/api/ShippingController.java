package com.temelt.shipping.api;

import com.temelt.common.dto.ShippingDto;
import com.temelt.shipping.entity.Shipping;
import com.temelt.shipping.service.ShippingService;
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
public class ShippingController {

    private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@RequestParam(name = "id") Long id) {
        Optional<Shipping> shipping = shippingService.getById(id);
        return shipping.isPresent() ? ResponseEntity.ok(shipping.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ShippingDto shippingDto) {
        Shipping shipping = shippingService.create(shippingDto);
        return ResponseEntity.ok(shipping);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Shipping> inventories = shippingService.getAll();
        return ResponseEntity.ok(inventories);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid Shipping shipping) {
        shippingService.update(shipping);
        return ResponseEntity.ok(true);
    }

}
