package com.example.vms2_final;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ServerTimestamp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class Update_Visitors extends AppCompatActivity implements View.OnClickListener {
    private int STORAGE_PERMISSION_CODE = 1;
    private EditText editTextname;
    private EditText editTextvehical;
    private EditText editTextpurpose;
    private EditText editTextemail;
    private EditText editTextnoofvisitors;
    private FirebaseFirestore db;
    Bitmap bmp, scalebmp;
    Date dateobj;
    DateFormat dateFormat;


    //    public Visitors_class Vistors;  // This was the mistake // check for the spellings dude
    public Visitors_class Visitors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__visitors);


        //  createPDF();

//        Visitors_class Visitors = (Visitors_class) getIntent().getSerializableExtra("Visitors"); // this was the mistake you dont initialize the class again in the method
        Visitors = (Visitors_class) getIntent().getSerializableExtra("Visitors");

        Log.v("testthisone", "log is working");

        db = FirebaseFirestore.getInstance();
        editTextname = findViewById(R.id.update_name);
        editTextvehical = findViewById(R.id.update_vehical);
        editTextpurpose = findViewById(R.id.update_purpose);
        editTextemail = findViewById(R.id.update_email);
        editTextnoofvisitors = findViewById(R.id.update_noofvisitors);



        editTextname.setText(Visitors.getName());
        editTextvehical.setText(Visitors.getVehical());
        editTextpurpose.setText(Visitors.getPurpose());
        editTextemail.setText(Visitors.getEmail());
        editTextnoofvisitors.setText(Visitors.getNo_of_vistiors());

        findViewById(R.id.button_update).setOnClickListener(this);
        findViewById(R.id.button_delete).setOnClickListener(this);
        findViewById(R.id.button_Create_pass).setOnClickListener(this);


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

    public void updatevisitors() {
        String name = editTextname.getText().toString();
        String vechial = editTextvehical.getText().toString();
        String purpose = editTextpurpose.getText().toString();
        String email = editTextemail.getText().toString();
        String no_of_visitors = editTextnoofvisitors.getText().toString();

        if (!hasValidationErrors(name, vechial, purpose, email, no_of_visitors)) {

            Visitors_class v = new Visitors_class(name, vechial, purpose, email, no_of_visitors, null);
//                Log.v("testthis",v.getTimestamp().toString());
//            db.collection("Visitors").document(Vistors.getId()) you were calling the wrong object //
            db.collection("Visitors").document(Visitors.getId()) // the object you were getting in the intent from last activity you have to use that one here!!!!
                    .update("email", v.getEmail(),
                            "name", v.getName(),

                            // "no_of_visitors", v.getNo_of_vistiors(),
                            "purpose", v.getPurpose(),
//                           "timestamp", v.getTimestamp().toString(),
                            "vehical", v.getVehical())
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(Update_Visitors.this, "Visitors Updated", Toast.LENGTH_LONG).show();
                        }
                    });
        }
    }

    private void createPDF() {

        Paint forLinePaint = new Paint();
        PdfDocument myPdfDocument = new PdfDocument();
        Paint paint = new Paint();
        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(250,350,1).create();
        PdfDocument.Page myPage = myPdfDocument.startPage(myPageInfo);
        Canvas canvas = myPage.getCanvas();
        SimpleDateFormat datePatterformat  = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
        paint.setTextSize(15.5f);
        paint.setColor(Color.rgb(0,50,250));

        canvas.drawText("VISITORS GATE PASS", 20,20,paint);
        paint.setTextSize(8.5f);
        canvas.drawText("Gate No.1 East",20,40,paint);
        canvas.drawText("Mumbai 400094",20,55,paint);
        forLinePaint.setStyle(Paint.Style.STROKE);
        forLinePaint.setPathEffect(new DashPathEffect(new float[]{5,5},0));
        forLinePaint.setStrokeWidth(2);
        canvas.drawLine(20,65,230,65,forLinePaint);

        canvas.drawText("Visitors Name: "+editTextname.getText(), 20,80,paint);
        canvas.drawLine(20,90,230,90,forLinePaint);
        canvas.drawText("purpose:"+editTextpurpose.getText(),20,105,paint);

        canvas.drawText("Email id: "+editTextemail.getText(),20,120,paint);
        canvas.drawText("Vehical No: "+editTextvehical.getText(),20,135,paint);
        canvas.drawText("No of Visitors: "+editTextnoofvisitors.getText(),20,175,paint);
        canvas.drawLine(20,210,230,210,forLinePaint);
        canvas.drawText("Date"+datePatterformat.format(new Date().getTime()),20,260,paint);


        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(12f);
        canvas.drawText("Visit Again!", canvas.getWidth()/2,320,paint);

        myPdfDocument.finishPage(myPage);
        File file = new File(Environment.getExternalStorageDirectory(), "visitors_gatepass.pdf");

        try {
            myPdfDocument.writeTo(new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        myPdfDocument.close();




    }

    private void deletevisitor() {
        db.collection("Visitors").document(Visitors.getId()).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Update_Visitors.this, "Visitor deleted ", Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(new Intent(Update_Visitors.this, Visitors_Activity.class));
                }
            }
        });

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_update:
                updatevisitors();
                break;
            case R.id.button_delete:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Are you sure about this?");
                builder.setMessage("Deletion is permanet!");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deletevisitor();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog ad = builder.create();
                ad.show();
                break;
            case R.id.button_Create_pass:
                if (ContextCompat.checkSelfPermission(Update_Visitors.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PERMISSION_GRANTED) {
                    Toast.makeText(Update_Visitors.this, "PDF created successfully", Toast.LENGTH_LONG).show();
                } else {
                    requestStoragePermission();
                }
                createPDF();
                ;
                break;


        }
    }

    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            new AlertDialog.Builder(this).setTitle("permission needed ").setMessage("This permission is needed to create Gatepass ").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).create().show();
        } else {
            ActivityCompat.requestPermissions(Update_Visitors.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == STORAGE_PERMISSION_CODE){
            if (grantResults.length>0 && grantResults[0] == PERMISSION_GRANTED){
                Toast.makeText(this,"Permission granted",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this,"Permission was denied",Toast.LENGTH_SHORT).show();
            }

        }
    }
}