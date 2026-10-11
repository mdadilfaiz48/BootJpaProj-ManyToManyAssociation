package com.adil.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="JPA_MTOM_FACULTY")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Faculty {
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName="FID_SEQ",initialValue=1,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer fid;
	@Column(length=30)
	@NonNull
	private String fname;
	@Column(length=30)
	@NonNull
	private String faddress;
    
	@ManyToMany(targetEntity=Student.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="JPA_MTOM_FACULTIES_STUDENTS", //third table
	joinColumns=@JoinColumn(name="faculty_id",referencedColumnName="fid"),//owing side fk column
	inverseJoinColumns=@JoinColumn(name="student_id",referencedColumnName="sid"))//non owing side fk column
	private Set<Student> studentsInfo = new HashSet<>();

	
	// toString
	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", faddress=" + faddress + "]";
	}
	
	
	
}
