package com.itea.android.itea_l2;

/**
 * Created by Ev on 08.12.2016.
 */

public interface Constants {
    String KEY = "DATA";
    String FILE_SAVE = "MyPref";
    String KEY_SAVE = "SAVE_MODE";
    String KEY_NOT_SAVE = "NOT_REMEMBER";

    String BUTTON_NO = "NO";
    String BUTTON_OK = "OK";

    int REQUEST_CODE = 1;

    String NAME_PATTERN = "^[A-Za-zА-Яа-я0-9]{15}";                     // Розалинд Аруша Аркадина Алталун Флоренс Луна, Криспиано де ла Сантисима, Робертсон О’Хара, Хана-Фани


    String LAST_NAME_PATTERN = "^[A-Za-zА-Яа-я0-9]{15}";                // Фан Тхи Ким Фук, Фан-дер-Флит, Тимофей Ефремович, Иванов

    String PHONE_PATTERN = "^[A-Za-zА-Яа-я0-9]{15}";                    // +380669270921

    String COUNTRY_PATTERN = "^[A-Za-zА-Яа-я0-9]";                      // Новая Гвинея

    String CITY_PATTERN = "^[A-Za-zА-Яа-я0-9]{15}";                     // Ивано-Франковск, Нью Йорк, Уэрта-дель-Рей

    String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    String NOTE_PATTERN = "^[.]{100}";


}