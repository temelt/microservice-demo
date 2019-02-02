package com.temelt.shipping.messaging;

import com.temelt.common.entity.RecordState;
import com.temelt.common.events.InventoryAmountSuccessEvent;
import com.temelt.shipping.entity.Shipping;
import com.temelt.shipping.repo.ShippingRepository;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by temelt on 1.02.2019.
 */
@Component
public class IncomingMessageListener {
    private final ShippingRepository shippingRepository;

    private final RestTemplate restTemplate;

    public IncomingMessageListener(ShippingRepository shippingRepository, RestTemplate restTemplate) {
        this.shippingRepository = shippingRepository;
        this.restTemplate = restTemplate;
    }

    @StreamListener(ShippingChannel.AMOUNT_SUCCESS)
    public void receiveInventoryAmountSuccessEvent(@Payload InventoryAmountSuccessEvent amountSuccessEvent) {
        Shipping shipping = shippingRepository.findByCommitId(amountSuccessEvent.getId());
        shipping.setRecordState(RecordState.COMMITTED);
        shippingRepository.save(shipping);
    }

}

