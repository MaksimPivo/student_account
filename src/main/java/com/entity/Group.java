package com.entity;

import com.entity.common.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "student_group")
@AttributeOverride(name = "id", column = @Column(name = "group_id"))
public class Group extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "id_from_source")
    private Long idFromSource;
    ;

    @ToString.Exclude
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "group")
    private List<JournalSite> journalSites = new ArrayList<>();

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "group")
    private List<Student> students = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "d_id")
    private Department department;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "group_discipline", joinColumns = {@JoinColumn(name = "g_id")}, inverseJoinColumns = {
            @JoinColumn(name = "d_id")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"g_id", "d_id"})})
    @JsonIgnore
    private List<Discipline> disciplines;
}
