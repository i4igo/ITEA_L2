package com.itea.android.itea_l2;

import android.widget.EditText;

/**
 * Created by Ev on 10.12.2016.
 */

public class ValidInput {

    /**
     * @param editText
     * @return
     */
    public static boolean validLogin(EditText editText) {
        if (editText.length() == 0) {
            editText.requestFocus();
            editText.setError("Check your login");
            return false;
        }
        return true;
    }

    // проверка пароля
    public static boolean validPassword(EditText editText) {
        if (editText.length() == 0) {
            editText.setError("Check your password");
            return false;
        }
        return true;
    }

    /**
     * активити 2
     */
    public static boolean validBSkip(EditText editText) {
        if (editText.length() != 0) {
            editText.requestFocus();
            editText.setError("Поле должно быть пустым");
            return false;
        }
        return true;
    }

    public static boolean validName(String content) {
        return content.matches(Constants.NAME_PATTERN);
    }

    public static boolean validLName(String content) {
        return content.matches(Constants.LAST_NAME_PATTERN);
    }

    public static boolean validPNumber(String content) {
        return content.matches(Constants.PHONE_PATTERN);
    }

    public static boolean validCountry(String content) {
        return content.matches(Constants.COUNTRY_PATTERN);
    }

    public static boolean validCity(String content) {
        return content.matches(Constants.CITY_PATTERN);
    }

    public static boolean validEmail(String content) {
        return content.matches(Constants.EMAIL_PATTERN);
    }

    public static boolean validNotes(String content) {
        return content.matches(Constants.NOTES_PATTERN);
    }
}