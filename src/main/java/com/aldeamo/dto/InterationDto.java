package com.aldeamo.dto;

import java.util.List;

public class InterationDto {
    
    List<Integer> arrayB;
    List<Integer> arrayAi;
    List<Integer> finalArray;
    
    public InterationDto() { }

    public InterationDto(List<Integer> arrayB, List<Integer> arrayAi, List<Integer> finalArray) {
        this.arrayB = arrayB;
        this.arrayAi = arrayAi;
        this.finalArray = finalArray;
    }

    public List<Integer> getArrayB() {
        return arrayB;
    }

    public void setArrayB(List<Integer> arrayB) {
        this.arrayB = arrayB;
    }

    public List<Integer> getArrayAi() {
        return arrayAi;
    }

    public void setArrayAi(List<Integer> arrayAi) {
        this.arrayAi = arrayAi;
    }

    public List<Integer> getFinalArray() {
        return finalArray;
    }

    public void setFinalArray(List<Integer> finalArray) {
        this.finalArray = finalArray;
    }
    
}