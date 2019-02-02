package com.temelt.common.events;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by temelt on 1.02.2019.
 */
@Data
public class InventoryAmountSuccessEvent implements Serializable {
    private UUID id;
    private Long inventoryId;
    private BigDecimal amount;
}
