package com.temelt.inventory.entity;

import com.temelt.common.entity.RecordState;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by temelt on 28.01.2019.
 */
@Data
@Entity
@Table
@EqualsAndHashCode(callSuper = false)
public class Inventory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 400)
    @NotNull
    private String name;

    @Column(name = "barcode", length = 100)
    @NotNull
    private String barcode;

    @Column(name = "available_amount", precision = 2, scale = 18)
    private BigDecimal availableAmount;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "record_state", length = 30)
    private RecordState recordState = RecordState.NOT_COMMITTED;
}
