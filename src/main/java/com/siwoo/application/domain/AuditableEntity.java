package com.siwoo.application.domain;

import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

@MappedSuperclass @Setter @ToString(doNotUseGetters = true)
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity<U> implements Serializable {


    @CreatedDate
    @Column(name="created_date")
    private LocalDateTime createdDate;

    public Optional<LocalDateTime> getCreatedDate() {
        return Optional.of(createdDate);
    }

    @CreatedBy
    @Column(name="created_by")
    private String createdBy;

    public Optional<String> getCreatedBy() {
        return Optional.of(createdBy);
    }

    @LastModifiedBy
    @Column(name="last_modified_by")
    private String lastModifiedBy;

    public Optional<String> getLastModifiedBy() {
        return Optional.of(lastModifiedBy);
    }

    @LastModifiedDate
    @Column(name="last_modified_date")
    private LocalDateTime lastModifiedDate;

    public Optional<LocalDateTime> getLastModifiedDate() {
        return Optional.of(lastModifiedDate);
    }


}
