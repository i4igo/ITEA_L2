package com.itea.android.itea_l2;

/**
 * Created by Ev on 10.12.2016.
 */

public class ValidInput {

    // проверка логина
    public static boolean validLogin(String content){
        if(content.length()!=0)
            return true;
        else
            return false;
    }

    // проверка пароля
    public static boolean validPassword(String content){
        if(content.length()!=0)
            return true;
        else
            return false;
    }

}
