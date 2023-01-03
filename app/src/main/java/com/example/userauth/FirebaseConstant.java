package com.example.userauth;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseConstant {
  public static   DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("User Data");
}
