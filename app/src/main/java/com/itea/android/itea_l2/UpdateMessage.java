package com.itea.android.itea_l2;

/**
 * Created by Ev on 10.01.2017.
 * класс служит типом передаваеммых данных
 * от нашего AsyncTask в GUI
 * через метод publishProgress() в метод onProgressUpdate()
 *
 * передаваемые данные это:
 *  - что уже подобрано (набор символов)
 *  - время, за которое подобран символ
 */

public class UpdateMessage {
    
    private String onHackPassword;
    private int time;

    public UpdateMessage(String onHackPassword, int time) {
        super();
        this.onHackPassword = onHackPassword;
        this.time = time;
    }
}
