package pl.estrix.shopsync.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CustomClass implements Serializable {

    private static final long serialVersionUID = -3777844998879928741L;

    private String value;

    public CustomClass(){

    }

    public CustomClass(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return String.format("CustomClass content: " + getValue());
    }

}