package com.temelt.shipping.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by temelt on 1.02.2019.
 */
public interface ShippingChannel {

    String AMOUNT_SUCCESS = "inventoryAmountSuccessIn";

    @Output
    MessageChannel inventoryAmountCheckOut();

    @Input
    SubscribableChannel inventoryAmountSuccessIn();
}
