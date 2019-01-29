package com.temelt.shipping.entity;

import com.temelt.common.entity.RecordState;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by temelt on 28.01.2019.
 */
@Data
@Entity
@Table
@EqualsAndHashCode(callSuper = false)
public class Shipping implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "inventory_id")
    @NotNull
    private Long inventoryId;

    @Column(name = "account_id")
    @NotNull
    private Long accountId;

    @Column(name = "amount", precision = 2, scale = 16)
    @NotNull
    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "shipment_date")
    @NotNull
    private Date shipmentDate;

    @Column(name = "description",length = 400)
    @NotNull
    private String description;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "record_state", length = 30)
    private RecordState recordState = RecordState.NOT_COMMITTED;
}
