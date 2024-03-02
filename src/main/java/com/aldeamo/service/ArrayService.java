package com.aldeamo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldeamo.entity.ArrayEntity;
import com.aldeamo.repository.IArrayRepository;

@Service
public class ArrayService implements IArrayService {

    @Autowired
    IArrayRepository arraysRepository;

    @Override
    public List<ArrayEntity> getAll() {
        return (List<ArrayEntity>) arraysRepository.findAll();
    }

}
