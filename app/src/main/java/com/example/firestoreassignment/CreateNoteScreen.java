package com.example.firestoreassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class CreateNoteScreen extends AppCompatActivity {
    EditText editTextUserName;
    Button buttonSave;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note_screen);

        editTextUserName = findViewById(R.id.et_user_name);
        buttonSave = findViewById(R.id.btn_save);
        buttonSave.setOnClickListener(view ->
        {
            saveToFirebase(view)   ;
        });

    }
    public void saveToFirebase(View v) {

        String username = editTextUserName.getText().toString();
        Map<String, Object> product = new HashMap<>();

        CollectionReference cities = db.collection("Users");



        if (!username.isEmpty()) {
            product.put("Note Name", username);


            ///------------------------------


            db.collection("Users")
                    .add(product)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                              @Override
                                              public void onSuccess(DocumentReference documentReference) {
                                                  openActivity2();
                                                  Log.e("TAG", "Data added successfully to database");
                                              }

                                          }
                    )

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.e("TAG", "Failed to add database");

                        }
                    });

        } else {
            Toast.makeText(this, "Please Fill fields", Toast.LENGTH_SHORT).show();
        }

    }

    public void openActivity2() {

        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }
}