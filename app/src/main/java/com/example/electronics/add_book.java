package com.example.electronics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class add_book extends AppCompatActivity {

    EditText adname, adauthor, adlink, adimg;
    Button but_add, but_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        adname = (EditText) findViewById(R.id.add_title);
        adauthor = (EditText) findViewById(R.id.add_author);
        adlink = (EditText) findViewById(R.id.add_link);
        adimg = (EditText) findViewById(R.id.add_img);

        but_add = (Button)findViewById(R.id.btn_add);
        but_back = (Button)findViewById(R.id.btn_back);

        but_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });

        but_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void insertData() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", adname.getText().toString());
        map.put("author", adauthor.getText().toString());
        map.put("link", adlink.getText().toString());
        map.put("url", adimg.getText().toString());


        FirebaseDatabase.getInstance().getReference().child("product").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(add_book.this, " Book added", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(add_book.this, " There is a problem ", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}