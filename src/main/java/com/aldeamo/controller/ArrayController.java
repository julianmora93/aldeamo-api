package com.aldeamo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aldeamo.business.IBar;
import com.aldeamo.dto.DefaultResponseDto;
import com.aldeamo.dto.ProcessResponse;
import com.aldeamo.entity.ArrayEntity;
import com.aldeamo.service.IArrayService;

@RestController
@RequestMapping
public class ArrayController {

    @Autowired
    IArrayService arraysService;

    @Autowired
    IBar bar;

    @GetMapping("/process/{iterations}/{dataStackId}")
    public DefaultResponseDto<List<Integer>> getProcess(@PathVariable int iterations, @PathVariable int dataStackId){
        return bar.executeProcess(iterations, dataStackId);
    }

    @GetMapping("/complete-process/{iterations}/{dataStackId}")
    public DefaultResponseDto<ProcessResponse> getCompleteProcess(@PathVariable int iterations, @PathVariable int dataStackId){
        return bar.executeCompleteProcess(iterations, dataStackId);
    }

    @GetMapping("/healt-check")
    public String executionCheck(){
        return "Servicios en ejecución - Prueba Aldeamo - Julian Mora";
    }

    @GetMapping("/get-all")
    public List<ArrayEntity> getAllArrays(){
        return arraysService.getAll();
    }

}