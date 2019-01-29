package com.temelt.shipping.service;

import com.temelt.common.dto.ShippingDto;
import com.temelt.shipping.entity.Shipping;
import com.temelt.shipping.repo.ShippingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by temelt on 28.01.2019.
 */
@Service
public class ShippingService {

    private final ShippingRepository shippingRepository;
    private final ModelMapper modelMapper;

    public ShippingService(ShippingRepository shippingRepository, ModelMapper modelMapper) {
        this.shippingRepository = shippingRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public Shipping create(ShippingDto shippingDto) {
        Shipping shipping = modelMapper.map(shippingDto, Shipping.class);
        shipping = shippingRepository.save(shipping);
        publishAmountCheckEvent(shipping);
        return shipping;
    }

    public Optional<Shipping> getById(Long id) {
        return shippingRepository.findById(id);
    }

    public List<Shipping> getAll() {
        return shippingRepository.findAll();
    }

    @Transactional
    public void update(Shipping shipping) {
        shippingRepository.save(shipping);
    }

    private void publishAmountCheckEvent(Shipping shipping) {
        // TODO
    }
}
