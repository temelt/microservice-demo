package com.temelt.shipping.repo;

import com.temelt.shipping.entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by temelt on 28.01.2019.
 */
@Transactional
public interface ShippingRepository extends JpaRepository<Shipping, Long> {

    Shipping findByCommitId(UUID id);

}
