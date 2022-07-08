package com.entity;

import com.entity.common.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "sub_group")
@AttributeOverride(name = "id", column = @Column(name = "sub_group_id"))
public class SubGroup extends AbstractEntity {

    @Column(name = "sub_group_number")
    private Byte subGroupNumber;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "subGroup")
    private List<Student> students;
}
