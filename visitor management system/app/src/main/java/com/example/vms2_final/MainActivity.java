package com.example.vms2_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.internal.$Gson$Preconditions;

import java.util.Date;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextname;
    private EditText editTextvehical;
    private EditText editTextpurpose;
    private EditText editTextemail;
    private EditText editTextnoofvisitors;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();


        editTextname = findViewById(R.id.edittext_name);
        editTextvehical = findViewById(R.id.edittext_vehical);
        editTextpurpose = findViewById(R.id.edittext_purpose);
        editTextemail = findViewById(R.id.edittext_email);
        editTextnoofvisitors = findViewById(R.id.edittext_no_visitors);

        findViewById(R.id.button_save).setOnClickListener(this);
        findViewById(R.id.textview_view_Visitors).setOnClickListener(this);
    }

    private boolean hasValidationErrors(String name, String vehical, String purpose, String date, String time) {
        if (name.isEmpty()) {
            editTextname.setError("Name required");
            editTextname.requestFocus();
            return true;
        }

        if (vehical.isEmpty()) {
            editTextvehical.setError("Vehical required");
            editTextvehical.requestFocus();
            return true;
        }

        if (purpose.isEmpty()) {
            editTextpurpose.setError("Purpose required");
            editTextpurpose.requestFocus();
            return true;
        }

        if (date.isEmpty()) {
            editTextemail.setError("Date required");
            editTextemail.requestFocus();
            return true;
        }

        if (time.isEmpty()) {
            editTextnoofvisitors.setError("Time required");
            editTextnoofvisitors.requestFocus();
            return true;
        }
        return false;
    }



        private void  saveVisitors(){
            String name = editTextname.getText().toString();
            String vehical = editTextvehical.getText().toString();
            String purpose = editTextpurpose.getText().toString();
            String email = editTextemail.getText().toString();
            String no_of_visitors = editTextnoofvisitors.getText().toString();

        if (!hasValidationErrors(name,vehical,purpose,email,no_of_visitors)){
            CollectionReference dbVisitors = db.collection("Visitors");

            Visitors_class visitors = new Visitors_class(
                    name,vehical,purpose,email,no_of_visitors,null);

            dbVisitors.add(visitors).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {

                    Toast.makeText(MainActivity.this,"data saved", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(MainActivity.this, e.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_save:
                saveVisitors();
                break;
            case R.id.textview_view_Visitors:
                startActivity(new Intent(this,Visitors_Activity.class));
                break;
        }
    }
}