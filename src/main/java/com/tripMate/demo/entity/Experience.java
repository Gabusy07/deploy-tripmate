package com.tripMate.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "EXPERIENCES")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "TITLE", length = 350, nullable = false)
    private String title;

    @Column(name = "SUBTITLE", length = 350, nullable = false)
    private String subtitle;


    @Column(name = "DESCRIPTION", columnDefinition="TEXT", nullable = false)
    @Lob
    private String description;


/*    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "EXPERIENCE_ID")
    private Set<Review> reviews = new HashSet<>();
*/

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "EXPERIENCE_ID")
    private Set<Image> images = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CITY_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private City city;

    @OneToMany(mappedBy = "experience")
    private List<Review> reviews = new ArrayList<>();

/*
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CONTACT_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Contact contact;
*/

    @Column(name = "ADDRESS", length = 350)
    private String address;

//    @Column(name = "AVERAGE_SCORE")
//    private float averageScore;

    @Column(name = "TOTAL_SCORE")
    @ColumnDefault("0")
    private int totalScore;
    @Column(name = "TOTAL_REVIEWS")
    @ColumnDefault("0")
    private int totalReviews;

    @Column(name = "LATITUDE")
    private float latitude;
    @Column(name = "LONGITUDE")
    private float longitude;


}
