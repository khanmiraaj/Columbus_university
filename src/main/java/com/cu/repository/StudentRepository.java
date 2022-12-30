package com.cu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cu.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
