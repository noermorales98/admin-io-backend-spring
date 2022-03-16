package com.io.admin.dto.users;

public class BeeceptorDTO {

    String status;
    String code;
    String message;

    public BeeceptorDTO() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BeceeptorDTO{" +
                "status='" + status + '\'' +
                ", id='" + code + '\'' +
                ", name='" + message + '\'' +
                '}';
    }

    public String toJSON() {
        return "{" +
                "\"status\":" +"\""+status+"\","+
                "\"id\":" +"\""+code+"\","+
                "\"name\":" +"\""+message+"\""+
                '}';
    }
}
