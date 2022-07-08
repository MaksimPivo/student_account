package com.entity;

import com.entity.common.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "content")
@AttributeOverride(name = "id",column = @Column(name = "content_id"))
public class Timetable extends AbstractEntity {

    @Column(name = "lesson_date")
    private LocalDate lessonDate;

    @Column(name = "lesson_number")
    private Integer lessonNumber;

    @Column(name = "discipline_name")
    private String disciplineName;

    @Column(name = "type_class_name")
    private String typeClassName;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "sub_group")
    private Integer subGroup;

    @Column(name = "frame")
    private String frame;

    @Column(name = "location")
    private String location;

    @Column(name = "teacher_fio")
    private String teacherFio;
}