package com.aldeamo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aldeamo.entity.ArrayEntity;

@Repository
public interface IArrayRepository extends CrudRepository<ArrayEntity, Integer> { }