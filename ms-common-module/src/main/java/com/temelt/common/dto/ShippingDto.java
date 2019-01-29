package com.temelt.common.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by temelt on 28.01.2019.
 */
@Data
public class ShippingDto {
    private Long id;
    @NotNull
    private Long inventoryId;
    @NotNull
    private Long accountId;
    @NotNull
    private BigDecimal amount;
    @NotNull
    private Date shipmentDate;
    @NotNull
    private String description;
}
