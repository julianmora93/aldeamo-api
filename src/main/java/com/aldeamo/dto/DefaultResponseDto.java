package com.aldeamo.dto;

public class DefaultResponseDto<T> {

    private Boolean Status;
    private String CodeStatus;
    private String Message;
    private T Data;

    public DefaultResponseDto() { }

    public DefaultResponseDto(Boolean status, String codeStatus, String message, T data) {
        Status = status;
        CodeStatus = codeStatus;
        Message = message;
        Data = data;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public String getCodeStatus() {
        return CodeStatus;
    }

    public void setCodeStatus(String codeStatus) {
        CodeStatus = codeStatus;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

}