package com.adil.service;


import java.util.Optional;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adil.entity.Faculty;
import com.adil.entity.Student;
import com.adil.repository.IFacultyRepository;
import com.adil.repository.IStudentRepository;

@Service
public class CollegeMgmtServiceImpl implements ICollegeMgmtService {
	
	@Autowired
	private IFacultyRepository facultyRepo;
	@Autowired
	private IStudentRepository studentRepo;

	@Override
	public void saveDataUsingParent() {
		// prepare parent object
		Faculty faculty1 = new Faculty("raja","hyd");
		Faculty faculty2 = new Faculty("rajesh","delhi");
		// prepare child object
		Student student1 = new Student("anil","hyd","CBIET");
		Student student2 = new Student("suresh","hyd","JBIET");
		Student student3 = new Student("sager","hyd","NBIET");
		
		// assign student to faculty
		faculty1.getStudentsInfo().add(student1);
		faculty1.getStudentsInfo().add(student2);
		faculty1.getStudentsInfo().add(student3);
		faculty2.getStudentsInfo().add(student1);
		faculty2.getStudentsInfo().add(student2);
		
		// assign faculty to student
		student1.getFacultiesInfo().add(faculty1);
		student1.getFacultiesInfo().add(faculty2);
		student2.getFacultiesInfo().add(faculty1);
		student2.getFacultiesInfo().add(faculty2);
		student3.getFacultiesInfo().add(faculty1);
		
		// save data using parent
		facultyRepo.save(faculty1);
		facultyRepo.save(faculty2);
		System.out.println("Faculty and the associated student are saved");
		
		
		

	}

	@Override
	public void loadDataUsingParent() {
		
		Iterable<Faculty> itFaculties = facultyRepo.findAll();
		itFaculties.forEach(faculty->{
			System.out.println("Parent ::"+faculty);
			Set<Student> childs= faculty.getStudentsInfo();
			childs.forEach(stud->{
				System.out.println("childs :"+stud);
			});
		});
		
		
	}

	@Override
	public void deleteDataUsingParent() {
		
		// Load parent
		Optional<Faculty> opt = facultyRepo.findById(3);
		if(opt.isPresent()) {
			Faculty faculty = opt.get();
			Set<Student> childs = faculty.getStudentsInfo();
			faculty.setStudentsInfo(null);
			childs.forEach(ch->{
				ch.setFacultiesInfo(null);
			});
			facultyRepo.save(faculty);
			System.out.println("faculty is removed from certian student");
			
	}
		
	}
}
