package sg.edu.rp.c346.id21036553.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


public class MainActivity extends AppCompatActivity {

    EditText etName, etNumber, etSize;
    Button btnReset, btnSubmit, btnTp, btnDate;
    TextView tvTime, tvShow, tvDate;
    CheckBox cbEnabled;
    int year, month, day;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        etSize = findViewById(R.id.etSize);
        cbEnabled = findViewById(R.id.cbEnabled);
        tvTime = findViewById(R.id.tvTime);
        btnTp = findViewById(R.id.btnTp);
        tvDate = findViewById(R.id.tvDate);
        btnDate = findViewById(R.id.btnDate);
        btnReset = findViewById(R.id.btnReset);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvShow = findViewById(R.id.tvShow);
        final Calendar calendar=Calendar.getInstance();

    //button for time
        btnTp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar= Calendar.getInstance();
                int hours = calendar.get(Calendar.HOUR_OF_DAY);
                int mins = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog= new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        c.set(Calendar.MINUTE,minute);
                        c.setTimeZone(TimeZone.getDefault());
                        SimpleDateFormat format= new SimpleDateFormat("k:mm a");
                        String time = format.format(c.getTime());
                        tvTime.setText("Time Selected: " + time);
                    }
                },hours ,mins,false);
                timePickerDialog.show();
            }
        });



            //btn for date
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDate.setText("Date Selected: " + dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pname = etName.getText().toString();
                String pNumber = etNumber.getText().toString();
                String pSize = etSize.getText().toString();
                String pdate = tvDate.getText().toString();
                String ptime = tvTime.getText().toString();


                if (cbEnabled.isChecked()) {
                    Toast.makeText(MainActivity.this, "Smoking Area Selected", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(MainActivity.this, "Smoking Area not Selected", Toast.LENGTH_LONG).show();

                }

                tvShow.setText("CONFIRMATION BOOKING" + "\n" + "Name: " + pname + "\n"+
                        "Phone Number: " + pNumber + "\n"+
                        "No. of pax: " + pSize + "\n"+
                       pdate + "\n" + ptime);



            }


        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               etName.setText("");
               etNumber.setText("");
               etSize.setText("");
               cbEnabled.setChecked(false);
               tvTime.setText("");
               tvDate.setText("");
               tvShow.setText("");
            }
        });
        }
    }
