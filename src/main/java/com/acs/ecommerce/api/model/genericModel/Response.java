package com.acs.ecommerce.api.model.genericModel;

//Class Generic model for response api
public class Response<T> {

    private Object data;
    private Boolean status;
    private String message;

    public Object getData() {
        return data;
    }

    public void setData(Object d) {
        data = d;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
