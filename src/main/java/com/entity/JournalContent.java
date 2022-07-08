package com.entity;

import com.entity.common.AbstractEntity;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@Table(name = "journal_content")
@AttributeOverride(name = "id", column = @Column(name = "journal_content_id"))
public class JournalContent extends AbstractEntity {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "journal_header_id")
	private JournalHeader journalHeader;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@Column(name = "presence")
	private Boolean presence;

	@Column(name = "lateness")
	private Short lateness;

	@Column(name = "grade")
	private Integer grade;

	@Column(name = "discription")
	private String discription;
}
