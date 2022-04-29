package com.example.gg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class logIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }
    String email = ((TextView)findViewById(R.id.userEmail)).getText().toString();
    String password = ((TextView)findViewById(R.id.userPassword)).getText().toString();

    JSONObject json = new JSONObject();
    try {
        json.put("email", email);
        json.put("password", password);
    } catch (JSONException e) {
        e.printStackTrace();
    }
    String baseUrl = "https://food.madskill.ru/auth/login";

    RequestQueue requestQueue = Volley.newRequestQueue(this);

    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, baseUrl, json,
            response -> startActivity(new Intent(this, MainScreen.class)),
            error -> Toast.makeText(this, "Не удалось авторизироваться.", Toast.LENGTH_LONG).show());
requestQueue.add(request);

}