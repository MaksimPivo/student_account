package com.entity;

import com.entity.common.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "discipline")
@AttributeOverride(name = "id", column = @Column(name = "discipline_id"))
public class Discipline extends AbstractEntity {

    @Column(name = "short_name")
    private String name;
    @Column(name = "id_from_source")
    private Long idFromSource;

    @ManyToMany(mappedBy = "disciplines", fetch = FetchType.EAGER)
    private List<Group> groups;

    @ToString.Exclude
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "discipline")
    private List<JournalSite> journalSites = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "d_id")
    private Department department;
}
