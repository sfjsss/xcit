package com.projectshadow.xcit.entity;

import javax.persistence.*;

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;


}
