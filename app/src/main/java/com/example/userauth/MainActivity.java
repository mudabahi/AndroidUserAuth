package com.example.userauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.userauth.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
ProgressDialog dialog;
String userUID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        dialog = new ProgressDialog(this);
        dialog.setMessage("Pleas wait....");
        dialog.setCancelable(false);

        binding.button2.setOnClickListener(view ->{
            userUID = UUID.randomUUID().toString();

            if(binding.editTextTextEmailAddress.getText().toString().isEmpty()){
                binding.editTextTextEmailAddress.setError("Email is Empty");
            }else if (binding.editTextTextPassword.getText().toString().isEmpty()){
                binding.editTextTextPassword.setError("Password is empty");
            }else {
                String email = binding.editTextTextEmailAddress.getText().toString();
                String password = binding.editTextTextPassword.getText().toString();
                UserModel userModel = new UserModel(email, password, userUID);

                FirebaseConstant.databaseReference.child(userUID).setValue(userModel).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Intent i = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(i);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error in Send data in firebase", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });




    }
}