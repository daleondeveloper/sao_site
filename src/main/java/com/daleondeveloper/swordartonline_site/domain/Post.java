package com.daleondeveloper.swordartonline_site.domain;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import com.daleondeveloper.swordartonline_site.domain.dao_enum.Post_type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//POJO object for post
@Entity
@Table(name = "Post")
@Getter
@Setter
@AllArgsConstructor
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //All Strings
    //
    //a description of what is in the post
    @JoinColumn(name = "description")
    private String description;

    @JoinColumn(name = "full_name")
    private String full_name;

    @JoinColumn(name = "name")
    private String name;

    @JoinColumn(name = "post_info_short")
    private String post_info_short;

    @JoinColumn(name = "type")
    private String groups;

    //Image
    @Lob
    @JoinColumn(name = "image_main", nullable = false)
    private byte[] image_main;

    //Enums
    @Enumerated(EnumType.STRING)
    @Column(name = "types")
    @Type(type = "pgsql_enum")
    private Post_type type;

    @OneToMany(mappedBy = "posts", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Video> videos = new ArrayList<>();

    public Post(){}
}
