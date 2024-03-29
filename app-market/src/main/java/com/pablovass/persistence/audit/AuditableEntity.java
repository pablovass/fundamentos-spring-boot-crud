package com.pablovass.persistence.audit;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
@MappedSuperclass
public class AuditableEntity {
    /**ESTOS DOS ULTIMOS CAMPOS SON PARA LA AUDITORIA*/
    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;
    @CreatedBy
    @Column(name ="created_by" )
    private String createdBy;
    @LastModifiedBy
    @Column(name ="modified_by" )
    private String modifiedBy;
}
