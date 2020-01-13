package com.daleondeveloper.swordartonline_site.domain;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Table(name = "Video_files")
@Getter
@Setter
@AllArgsConstructor
@TypeDef(
        name = "string-array",
        typeClass = StringArrayType.class
)
public class Video implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //All Strings

    @JoinColumn(name = "name")
    private String name;

    @JoinColumn(name = "director")
    private String director;

    @JoinColumn(name = "description")
    private String description;

    //Arrays
    @Type(type = "string-array")
    @Column(
            name = "genres",
            columnDefinition = "text[]"
    )
    private String[] genres;

    @Type(type = "string-array")
    @Column(
            name = "categories",
            columnDefinition = "text[]"
    )
    private String[] categories;

   // Numbers
    @JoinColumn(name = "issue_number")
    private short issue_number;


    //Date and Time

    @JoinColumn(name = "graduation_year")
    private int graduation_year;

    @JoinColumn(name = "duration")
    private LocalTime duration;

    //Video
    @Lob
    @JoinColumn(name = "video_480")
    private byte[] video_480;

    @Lob
    @JoinColumn(name = "video_720")
    private byte[] video_720;

    //All
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_posts")
    private Post posts;

    public Video(){}
}
