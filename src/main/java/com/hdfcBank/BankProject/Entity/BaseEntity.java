package com.hdfcBank.BankProject.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.Instant;

@Data
@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {
    @Column(name = "Record_created_dt",updatable = false)
    private Instant recordCreatedDate;

    @Column(name="Record_updated_dt",updatable = true)
    private Instant recordUpdatedDate;

    @Column(name = "Record_updated_by",updatable = true)
    private  String recordUpdatedBy;

    @Column(name = "Record_created_by",insertable = true)
    private  String recordCreatedBy;

}
