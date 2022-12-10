package com.example.tictaitoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChoiseGameMode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choise_game_mode);
    }

    public void OneGamer(View view) {
        Intent intent = new Intent(ChoiseGameMode.this, GameActivityWithComputer.class);
        startActivity(intent);
        finish();
    }

    public void TwoGamers(View view) {
        Intent intent = new Intent(ChoiseGameMode.this, GameActivity.class);
        startActivity(intent);
        finish();

    }

    public void click_back(View view) {
        onBackPressed();
    }

    public void onBackPressed() {
        Intent intent = new Intent(ChoiseGameMode.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}