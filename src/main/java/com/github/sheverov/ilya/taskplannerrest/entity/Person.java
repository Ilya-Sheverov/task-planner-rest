package com.github.sheverov.ilya.taskplannerrest.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "persons", schema = "public")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "person_id_seq")
    @Column(name = "person_id", nullable = false)
    private Integer personId;

    @Column(name = "last_name", nullable = false, length = 35)
    private String lastName;

    @Column(name = "first_name", nullable = false, length = 35)
    private String firstName;

    @Column(name = "middle_name", nullable = false, length = 35)
    private String middleName;

    @Version
    @Column(name = "version", nullable = false)
    private Timestamp version;

    @ManyToMany(mappedBy = "assignees")
    private List<Task> tasks = new ArrayList<>();
}

