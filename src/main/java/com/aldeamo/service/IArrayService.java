package com.aldeamo.service;

import java.util.List;
import java.util.Optional;

import com.aldeamo.entity.ArrayEntity;

public interface IArrayService {

    List<ArrayEntity> getAll();

    Optional<ArrayEntity> getById(Integer id);

}