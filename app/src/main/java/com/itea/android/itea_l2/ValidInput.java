package com.itea.android.itea_l2;

import android.widget.EditText;

/**
 * Created by Ev on 10.12.2016.
 */

public class ValidInput {

    private static final String NAME_PATTERN =
            "^[A-Za-z0-9]{3,}";

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    /**ативити 1
     *
     * @param content
     * @return
     */
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

    /**активити 2*/
    public static boolean validBSkip(EditText editText){
        if (editText.length() != 0) {
            editText.requestFocus();
            editText.setError("Поле должно быть пустым");
            return false;
        }
        return true;
    }

    public static boolean validName(String content){
        return content.matches(EMAIL_PATTERN);
    }

    public static boolean validLName(String content){
        return content.matches(EMAIL_PATTERN);
    }

    public static boolean validPNumber(String content){
        return content.matches(EMAIL_PATTERN);
    }

    public static boolean validCountry(String content){
        return content.matches(EMAIL_PATTERN);
    }

    public static boolean validCity(String content){
        return content.matches(EMAIL_PATTERN);
    }

    public static boolean validEmail(String content){
        return content.matches(EMAIL_PATTERN);
    }


}
