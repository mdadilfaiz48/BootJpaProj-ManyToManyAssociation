package com.adil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adil.entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
