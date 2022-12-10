package com.example.tictaitoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class GameActivityWithComputer extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_with_computer);

        sharedPreferences = this.getSharedPreferences("crossZero", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void EasyBotStart (View view) {
        editor.putString("difficult", "easy");
        editor.apply();
        Intent intent = new Intent(GameActivityWithComputer.this, GameVsComputer.class);
        startActivity(intent);
        finish();
    }

    public void MediumBotStart (View view) {
        editor.putString("difficult", "medium");
        editor.apply();
        Intent intent = new Intent(GameActivityWithComputer.this, GameVsComputer.class);
        startActivity(intent);
        finish();
    }

    public void HeavyBotStart (View view) {
        editor.putString("difficult", "hard");
        editor.apply();
        Intent intent = new Intent(GameActivityWithComputer.this, GameVsComputer.class);
        startActivity(intent);
        finish();
    }

    public void GodBotStart (View view) {
        editor.putString("difficult", "god");
        editor.apply();
        Intent intent = new Intent(GameActivityWithComputer.this, GameVsComputer.class);
        startActivity(intent);
        finish();
    }

    public void click_back(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        editor.putString("difficult", "");
        editor.apply();
        Intent intent = new Intent(GameActivityWithComputer.this, ChoiseGameMode.class);
        startActivity(intent);
        finish();
    }
}