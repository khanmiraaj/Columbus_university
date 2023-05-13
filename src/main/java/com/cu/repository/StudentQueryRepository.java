package com.cu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cu.entity.StudentQuery;

public interface StudentQueryRepository extends JpaRepository<StudentQuery, Integer>{

}
