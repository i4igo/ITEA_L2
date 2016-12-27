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

    int PICK_IMAGE_REQUEST = 12345;

    int REQUEST_CODE = 1;

    // Cаша, Криспиано де ла Сантисима, Робертсон О’Хара, Хана-Фани
    String NAME_PATTERN = "^(([A-Za-zА-Яа-я]+)(([-']|[ ])([A-Za-zА-Яа-я])+)*)+$";

    // Фан Тхи Ким Фук, Фан-дер-Флит, Тимофей Ефремович, Иванов
    String LAST_NAME_PATTERN = "^(([A-Za-zА-Яа-я]+)(([-]|[ ])([A-Za-zА-Яа-я])+)*)+$";

    // +380669301527
    String PHONE_PATTERN = "^\\+38([0][5-9][0-9])([0-9]){7}$";

    // Новая Гвинея
    String COUNTRY_PATTERN = "^([A-Za-zА-Яа-я]+)(([ ])([A-Za-zА-Яа-я])+)*$";

    // Ивано-Франковск, Нью Йорк, Уэрта-дель-Рей
    String CITY_PATTERN = "^([A-Za-zА-Яа-я]+)(([-]|[ ])([A-Za-zА-Яа-я])+)*$";

    //ppp.f@jhdfs.com
    String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})+$";

    // любые символы
    String NOTES_PATTERN = "^(.){0,100}$";
}