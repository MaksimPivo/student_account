package com.entity;

import java.util.List;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.entity.common.AbstractEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "departments")
@AttributeOverride(name = "id", column = @Column(name = "d_id"))
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Department extends AbstractEntity {

    @Column(name = "d_name")
    String name;

    @Column(name = "d_display_name")
    String displayName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Teacher> teachers;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Group> groups;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Discipline> disciplines;
}
