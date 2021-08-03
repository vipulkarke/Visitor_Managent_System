package com.example.vms2_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_Parent extends AppCompatActivity {
    private Button gatepass;
    private Button logs;
    private Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__parent);
        gatepass = (Button)findViewById(R.id.gatepassbtn);
        logs = (Button)findViewById(R.id.logsbtn);
        logout = (Button)findViewById(R.id.logoutbtn);
        gatepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_Parent.this, MainActivity.class);
                startActivity(intent);
            }
        });

        logs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_Parent.this, Visitors_Activity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_Parent.this, Login.class);
                startActivity(intent);
            }
        });
    }
}