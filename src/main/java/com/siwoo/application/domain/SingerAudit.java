package com.siwoo.application.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Optional;

@Getter @Setter @ToString(callSuper = true)
@Entity @EntityListeners(AuditingEntityListener.class)
@Table(name="singer_audit")
public class SingerAudit extends AuditableEntity<SingerAudit> implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="birth_date")
    private LocalDateTime birthDate;




}
