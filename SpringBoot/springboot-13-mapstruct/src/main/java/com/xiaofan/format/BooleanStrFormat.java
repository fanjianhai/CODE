package com.xiaofan.format;

import org.springframework.stereotype.Component;

@Component
public class BooleanStrFormat {
    public String toStr(Boolean isDisable) {
        if (isDisable) {
            return "Y";
        } else {
            return "N";
        }
    }
    public Boolean toBoolean(String str) {
        if (str.equals("Y")) {
            return true;
        } else {
            return false;
        }
    }
}


