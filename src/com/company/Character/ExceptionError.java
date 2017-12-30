package com.company.Character;

import java.util.ArrayList;
import java.util.List;

public class ExceptionError extends Exception {
    private List<?> tempList;
    private Object tempVariable;

    ExceptionError(List<?> tempList, Object tempVariable){
        this.tempList = tempList;
        this.tempVariable = tempVariable;
    }

    public List<?> getTempList() {
        return tempList;
    }

    public Object getTempVariable() {
        return tempVariable;
    }
}
