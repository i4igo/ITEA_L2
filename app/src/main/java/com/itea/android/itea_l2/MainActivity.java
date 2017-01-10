package com.itea.android.itea_l2;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etInPassword;
    private RadioGroup rgMode;
    private RadioButton rbHandler;
    private RadioButton rbAsyncTask;
    private Button bHack;
    private CheckBox cbRun;
    private ProgressBar pb;
    private TextView tvTime;
    private TextView tvPassword;
    private TextView tvInfo;

    private Handler handler;
    private AsyncTask<String, UpdateMessage, Void> asyncTask;

    private boolean isTaskStart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInPassword = (EditText) findViewById(R.id.etInPassword);
        rgMode = (RadioGroup) findViewById(R.id.rgMode);
        rbHandler = (RadioButton) findViewById(R.id.rbHandler);
        rbAsyncTask = (RadioButton) findViewById(R.id.rbAsyncTask);
        bHack = (Button) findViewById(R.id.bHack);
        cbRun = (CheckBox) findViewById(R.id.cbRun);
        pb = (ProgressBar) findViewById(R.id.pb);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvPassword = (TextView) findViewById(R.id.tvPassword);
        tvInfo = (TextView) findViewById(R.id.tvInfo);

        handler = new TestHandler(this);
    }

    @Override
    public void onClick(View v) {
        final String needToHack = etInPassword.getText().toString();
        pb.setVisibility(View.VISIBLE);
        tvInfo.setVisibility(View.INVISIBLE);

        switch (rgMode.getCheckedRadioButtonId()) {

            case R.id.rbHandler:

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {

                        String needToHackAT = etInPassword.getText().toString();

                        // обьявляем стартовую позицию индекс
                        int indexHachPassword = 0;

                        // задаем стартовое время
                        long timeStart = System.currentTimeMillis();
                        StringBuilder sbHackResult = new StringBuilder();

                        // проводим подбор пароля
                        while (indexHachPassword < needToHackAT.length()) {

                            // проход с первого элемента по z
                            for (char c = '\u0000'; c < 'z'; c++) {

                                if (c == needToHackAT.charAt(indexHachPassword)) {
                                    try {
                                        Thread.sleep(500);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    // создаем обьект передаваемых данных
                                    Message message = new Message();
                                    Bundle bundle = new Bundle();
                                    bundle.putLong(Constants.MESSAGE_TIME, System.currentTimeMillis() - timeStart);
                                    bundle.putString(Constants.MESSAGE_PASSWORD, sbHackResult.append(c).toString());
                                    message.setData(bundle);

                                    message.what = Constants.MESSAGE_IN_PROGRESS;

                                    handler.sendMessage(message);

                                    indexHachPassword++;
                                    break;
                                }
                            }
                        }

                        //отправляем данные
                        Message message = new Message();
                        Bundle bundle = new Bundle();
                        bundle.putLong(Constants.MESSAGE_TIME, (System.currentTimeMillis() - timeStart));
                        bundle.putString(Constants.MESSAGE_PASSWORD, sbHackResult.toString());
                        message.setData(bundle);

                        message.what = Constants.MESSAGE_HACK_END;

                        handler.sendMessage(message);

                    }

                };

                Thread threadHandler = new Thread(runnable);
                threadHandler.start();

                break;

            /**
             * здесь запускается и останавливается AsyncTask
             * используем boolean переменную для опредения состояния потока
             *  - если запущен - остановить
             *  - в обратном случае - запустить
             */
            case R.id.rbAsyncTask:


                if (isTaskStart) {

                    // остановили обновление графики
                    asyncTask.cancel(true);
                    // кнопка снова стала "взломать пароль"
                    bHack.setText("HACK");
                    // связь прервана
                    isTaskStart = false;

                } else {
                    // создаем новый поток и запускаем его
                    asyncTask = new TestAsyncTask();
                    asyncTask.execute(needToHack);
                    // кнопка стала "стоп"
                    bHack.setText("STOP");
                    isTaskStart = true;

                }

                break;

            default:
                break;
        }
    }

    class TestHandler extends Handler {

        private WeakReference<MainActivity> wrActivity;

        //конструктор
        public TestHandler(MainActivity activity) {
            this.wrActivity = new WeakReference<MainActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            // получаем ссылку на нашу активность и доступ к GUI
            MainActivity activity = wrActivity.get();
            if (activity != null) {
                // получаем данные и изменяем данные в GUI
                Bundle bundle = msg.getData();
                activity.tvTime.setText("" + bundle.getLong(Constants.MESSAGE_TIME) + " ms");
                activity.tvPassword.setText(bundle.getString(Constants.MESSAGE_PASSWORD));

                if (msg.what == Constants.MESSAGE_HACK_END) {
                    activity.tvInfo.setVisibility(View.VISIBLE);
                    activity.pb.setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    class TestAsyncTask extends AsyncTask<String, UpdateMessage, Void> {

        // подготавливаем данные
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        // создаем новый процесс
        @Override
        protected Void doInBackground(String... params) {

            // получаем данные от метода execute(), пароль который мы должны подобрать
            String needToHackAT = params[0];
            // обьявляем стартовую позицию индекс
            int indexHachPassword = 0;
            // задаем стартовое время
            long timeStart = System.currentTimeMillis();
            // получаем данные от метода execute(), пароль который мы должны подобрать
            StringBuilder sbHackResult = new StringBuilder();

            // проход по каждому символу пароля
            while (indexHachPassword < needToHackAT.length()) {

                // проход с первого элемента по z

                for (char c = '\u0000'; c < 'z'; c++) {

                    if (c == needToHackAT.charAt(indexHachPassword)) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        // создаем обьект передаваемых данных
                        UpdateMessage um = new UpdateMessage(
                                sbHackResult.append(c).toString(),
                                (int) (System.currentTimeMillis() - timeStart)
                        );

                        //передаем данные (свой тип данных, класс UpdateMessage) в метод onProgressUpdate()
                        publishProgress(um);

                        indexHachPassword++;
                        break;
                    }
                }
            }

            return null;
        }

        // получаем данные с метода publishProgress()
        @Override
        protected void onProgressUpdate(UpdateMessage... values) {
            //super.onProgressUpdate(values);

            tvPassword.setText(values[0].getOnHackPassword());
            tvTime.setText("" + values[0].getTime() + " ms");
        }

        // получаем результат работы
        @Override
        protected void onPostExecute(Void aVoid) {
            //super.onPostExecute(aVoid);
            pb.setVisibility(View.INVISIBLE);
            tvInfo.setVisibility(View.VISIBLE);
            bHack.setText("HACK");
            isTaskStart = false;
        }

        // останавливаем обновление данных экрана
        @Override
        protected void onCancelled(Void aVoid) {
            super.onCancelled(aVoid);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }


    }
}