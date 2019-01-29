package com.temelt.shipping.api;

import com.temelt.common.dto.ShippingDto;
import com.temelt.shipping.entity.Shipping;
import com.temelt.shipping.service.ShippingService;
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
@Api(value = "Shipping APIs")
public class ShippingController {

    private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Get Shipping By Id")
    public ResponseEntity<?> getById(@RequestParam(name = "id") Long id) {
        Optional<Shipping> shipping = shippingService.getById(id);
        return shipping.isPresent() ? ResponseEntity.ok(shipping.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @ApiOperation(value = "Create Shipping")
    public ResponseEntity<?> create(@RequestBody @Valid ShippingDto shippingDto) {
        Shipping shipping = shippingService.create(shippingDto);
        return ResponseEntity.ok(shipping);
    }

    @GetMapping
    @ApiOperation(value = "Get All Shippings")
    public ResponseEntity<?> getAll() {
        List<Shipping> inventories = shippingService.getAll();
        return ResponseEntity.ok(inventories);
    }

    @PutMapping
    @ApiOperation(value = "Update Shipping")
    public ResponseEntity<?> update(@RequestBody @Valid Shipping shipping) {
        shippingService.update(shipping);
        return ResponseEntity.ok(true);
    }

}
