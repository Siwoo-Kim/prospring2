package com.siwoo.application.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Instrument {

    @Id
    @Column(name="instrument_id")
    private String instrumentId;

    @ManyToMany
    @JoinTable(name="singer_instrument",
    joinColumns = @JoinColumn(name="instrument_id"),
    inverseJoinColumns = @JoinColumn(name="singer_id"))
    private Set<Singer> singers = new HashSet<>();
}
