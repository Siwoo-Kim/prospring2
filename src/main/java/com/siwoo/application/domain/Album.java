package com.siwoo.application.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity @NoArgsConstructor
@Getter @Setter @ToString
public class Album implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    private String title;

    @Column(name="release_date")
    private LocalDateTime releaseDate;

    @ManyToOne
    @JoinColumn(name="singer_id")
    private Singer singer;

    public Album(String title, LocalDateTime releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public void setSinger(Singer singer){
        if(this.singer != singer){
            this.singer = singer;
        }
    }
}
