package com.phong.hocdateandtimepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txtDate;
    ImageView imgDate;
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    TextView txtTime;
    ImageView imgTime;
    Calendar calendarTime = Calendar.getInstance();
    SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addcontrols();
        addEvents();
    }

    private void addEvents() {
        imgDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoManHinhDatePickerDialog();
            }
        });
        imgTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoManHinhTimePickerDialog();
            }
        });
    }

    private void MoManHinhTimePickerDialog() {
        TimePickerDialog.OnTimeSetListener callBack = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                calendarTime.set(Calendar.HOUR,i);
                calendarTime.set(Calendar.MINUTE,i1);
                txtTime.setText(simpleDateFormatTime.format(calendarTime.getTime()));
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                MainActivity.this,
                callBack,
                calendarTime.get(Calendar.HOUR),
                calendarTime.get(Calendar.MINUTE),
                true
        );
        timePickerDialog.show();
    }

    private void MoManHinhDatePickerDialog() {
        //Call back trước: callback là events dùng để lắng nghe thông tin người dùng thay đổi trên giao diện
        DatePickerDialog.OnDateSetListener callBack = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR,i);
                calendar.set(Calendar.MONTH,i1);
                calendar.set(Calendar.DAY_OF_MONTH,i2);
                txtDate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                MainActivity.this,
                callBack,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    private void addcontrols() {
        txtDate = (TextView) findViewById(R.id.txtDate);
        imgDate = (ImageView) findViewById(R.id.imgDate);

        txtTime = (TextView) findViewById(R.id.txtTime);
        imgTime = (ImageView) findViewById(R.id.imgTime);
    }
}
