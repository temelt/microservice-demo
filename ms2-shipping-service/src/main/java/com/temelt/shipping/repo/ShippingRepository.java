package com.temelt.shipping.repo;

import com.temelt.shipping.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by temelt on 28.01.2019.
 */
public interface ShippingRepository extends JpaRepository<Shipping, Long> {
}
