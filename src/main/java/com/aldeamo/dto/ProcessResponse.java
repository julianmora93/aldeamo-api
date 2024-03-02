package com.aldeamo.dto;

import java.util.List;

public class ProcessResponse {
    
    List<InterationDto> process;
    List<Integer> response;
    
    public ProcessResponse() { }

    public ProcessResponse(List<InterationDto> process, List<Integer> response) {
        this.process = process;
        this.response = response;
    }

    public List<InterationDto> getProcess() {
        return process;
    }

    public void setProcess(List<InterationDto> process) {
        this.process = process;
    }

    public List<Integer> getResponse() {
        return response;
    }

    public void setResponse(List<Integer> response) {
        this.response = response;
    }

}