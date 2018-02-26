package com.siwoo.application.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@ToString(exclude = {"albums","instruments"}) @Getter @Setter
@Entity @Table(name="singer")
@NamedQueries({
        @NamedQuery(name = Singer.JPQL_FINDALL,query = "select s from Singer s"),
        @NamedQuery(name = Singer.JPQL_FIND_BY_ID,
        query = "select distinct s from Singer s " +
                "left join fetch s.albums a " +
                "left join fetch s.instruments i " +
                "where s.id = :id"),
        @NamedQuery(name = Singer.JPQL_FINDALL_WITH_ALBUM,
        query = "select distinct s from Singer s " +
                "left join fetch s.albums a " +
                "left join fetch s.instruments i ")
})
@SqlResultSetMapping(
        name="singerResult",
        entities = @EntityResult(entityClass = Singer.class)
)
public class Singer implements Serializable{

    public static final String JPQL_FINDALL = "Singer.findAll";
    public static final String JPQL_FIND_BY_ID = "Singer.findById";
    public static final String JPQL_FINDALL_WITH_ALBUM = "Singer.findAllWithAlbum";

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Version
    private int version;

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="birth_date")
    private LocalDate birthDate;
    @OneToMany(mappedBy = "singer",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Album> albums = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "singer_instrument",
    joinColumns = @JoinColumn(name="singer_id"),
    inverseJoinColumns = @JoinColumn(name="instrument_id"))
    private Set<Instrument> instruments = new HashSet<>();

    public void addAlbum(Album album) {
        album.setSinger(this);
        albums.add(album);
    }
}
