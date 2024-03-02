package com.aldeamo.business;

import java.util.List;

import com.aldeamo.dto.DefaultResponseDto;
import com.aldeamo.dto.ProcessResponse;

public interface IBar {
    DefaultResponseDto<List<Integer>> executeProcess(Integer iterations, Integer dataStackId);
    DefaultResponseDto<ProcessResponse> executeCompleteProcess(Integer iterations, Integer dataStackId);
}