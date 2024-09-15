package com.arfan.auth.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    @Column(name = "CREATED_DATE", insertable = true, updatable = false)
    private Date createdDate;

    @Column(name = "CREATED_BY", insertable = true, updatable = false)
    private String createdBy;

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "MODIFIED_BY")
    private String lastModifiedBy;
}
