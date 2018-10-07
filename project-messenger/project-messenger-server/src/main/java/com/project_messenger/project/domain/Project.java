package com.project_messenger.project.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class Project implements Serializable {

    // @Id
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
    // "ProjectSeqGenerator")
    // @SequenceGenerator(name = "ProjectSeqGenerator", sequenceName =
    // "PROJECT_ID_SEQ", allocationSize = 1)
    private Long id;

    @NotNull
    private String title;

    private String description;

    private String uuid;

    public Project(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void update(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public String uuid() {
        return uuid;
    }

}
