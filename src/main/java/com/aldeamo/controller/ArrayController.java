package com.aldeamo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aldeamo.entity.ArrayEntity;
import com.aldeamo.service.IArrayService;

@RestController
@RequestMapping("arrays")
public class ArrayController {

    @Autowired
    IArrayService arraysService;

    @GetMapping("/execution-check")
    public String executionCheck(){
        return "Servicio en ejecución!   :P";
    }

    @GetMapping("/get-all")
    public List<ArrayEntity> getAllArrays(){
        return arraysService.getAll();
    }

}