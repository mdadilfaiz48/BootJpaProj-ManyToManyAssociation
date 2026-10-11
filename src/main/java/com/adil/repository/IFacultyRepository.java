package com.adil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adil.entity.Faculty;

public interface IFacultyRepository extends JpaRepository<Faculty, Integer> {

}
