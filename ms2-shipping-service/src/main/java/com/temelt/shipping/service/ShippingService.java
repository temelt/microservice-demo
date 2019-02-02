package com.temelt.shipping.service;

import com.temelt.common.dto.ShippingDto;
import com.temelt.common.events.InventoryAmountCheckEvent;
import com.temelt.shipping.entity.Shipping;
import com.temelt.shipping.messaging.ShippingChannel;
import com.temelt.shipping.repo.ShippingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by temelt on 28.01.2019.
 */
@Service
public class ShippingService {

    private final ShippingRepository shippingRepository;
    private final ModelMapper modelMapper;
    private final ShippingChannel shippingChannel;

    public ShippingService(ShippingRepository shippingRepository, ModelMapper modelMapper, ShippingChannel shippingChannel) {
        this.shippingRepository = shippingRepository;
        this.modelMapper = modelMapper;
        this.shippingChannel = shippingChannel;
    }

    public Shipping create(ShippingDto shippingDto) {
        Shipping shipping = modelMapper.map(shippingDto, Shipping.class);

        InventoryAmountCheckEvent amountCheckEvent = new InventoryAmountCheckEvent();
        shipping.setCommitId(amountCheckEvent.getId());

        shipping = shippingRepository.save(shipping);

        amountCheckEvent.setAmount(shippingDto.getAmount());
        amountCheckEvent.setInventoryId(shippingDto.getInventoryId());
        shippingChannel.inventoryAmountCheckOut().send(MessageBuilder.withPayload(amountCheckEvent).build());

        return shipping;
    }

    public Optional<Shipping> getById(Long id) {
        return shippingRepository.findById(id);
    }

    public List<Shipping> getAll() {
        return shippingRepository.findAll();
    }

    public void update(Shipping shipping) {
        shippingRepository.save(shipping);
    }


}
