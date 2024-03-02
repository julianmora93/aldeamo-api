package com.aldeamo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aldeamo.entity.ArrayEntity;

@Repository
public interface IArrayRepository extends JpaRepository<ArrayEntity, Integer> { }