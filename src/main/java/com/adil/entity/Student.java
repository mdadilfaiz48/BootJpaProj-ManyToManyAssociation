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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA_MTOM_STUDENT")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {

	@Id
	@SequenceGenerator(name="gen1",sequenceName="SID_SEQ",initialValue=100,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer sid;
	@Column(length=30)
	@NonNull
	private String sname;
	@Column(length=30)
	@NonNull
	private String saddress;
	@Column(length=30)
	@NonNull
	private String college;
	
	@ManyToMany(targetEntity=Faculty.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="studentsInfo")
	private Set<Faculty> facultiesInfo = new HashSet();

	//toString
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", college=" + college + "]";
	}
	
	
	
	
	
}
