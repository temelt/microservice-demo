package com.temelt.account.entity;

import com.temelt.common.entity.RecordState;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by temelt on 28.01.2019.
 */
@Data
@Entity
@Table
@EqualsAndHashCode(callSuper = false)
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "account_name", length = 400)
    @NotNull
    private String accountName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date")
    private Date registrationDate = Calendar.getInstance().getTime();

    @Enumerated(value = EnumType.STRING)
    @Column(name = "record_state",length = 30)
    private RecordState recordState = RecordState.NOT_COMMITTED;
}
