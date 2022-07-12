package com.util;


import lombok.Data;

@Data
public class Datainfo {
    private boolean flog;
    private Object data;

    public Datainfo(){}

    public Datainfo(Boolean flog){
        this.flog = flog;
    }

    public Datainfo(Boolean flog,Object data){
        this.flog=flog;
        this.data=data;
    }

}
