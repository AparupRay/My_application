package com.example.happy_birthday;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class schedule extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextView current_date;
    ImageView calender_date;
    CalendarView calenderView;
    private  RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("SEND WISHES");
        setSupportActionBar(toolbar);

        current_date = findViewById(R.id.current_date);
        Calendar calendar = Calendar.getInstance();
        String Currentdate = DateFormat.getDateInstance().format(calendar.getTime());
        current_date.setText("Today's Date - "+ Currentdate);

        calender_date = findViewById(R.id.calender_date);

        calender_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");

            }
        });


        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        for(int i =0;i<=6;i++){

            ListItem listItem = new ListItem("User"+(i+1));

            listItems.add(listItem);
        }

        adapter = new MyAdapter(listItems,this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

          Calendar c = Calendar.getInstance();
          c.set(Calendar.YEAR,year);
          c.set(Calendar.MONTH,month);
          c.set(Calendar.DAY_OF_MONTH,dayOfMonth);

          /* String Current_date_String = DateFormat.getDateInstance.format(c.getTime()); */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.user:

                Login.googleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //On Successful sign out we navigate the user back to LoginActivity
                        Intent intent=new Intent(getApplicationContext(),Login.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
