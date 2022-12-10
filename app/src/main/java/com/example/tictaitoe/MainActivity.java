package com.example.tictaitoe;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("crossZero", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void start_game(View view) {
        Intent intent = new Intent(MainActivity.this, ChoiseGameMode.class);
        startActivity(intent);
        finish();
    }

    public void Credits(View view) {
        Intent intent = new Intent(MainActivity.this, CreditsActivity.class);
        startActivity(intent);
        finish();
    }

    public void exitGame(View view) {
        onDestroy();
        finishAndRemoveTask();
    }

    @Override
    protected void onDestroy() {
        editor.putInt("points_player1", 0);
        editor.apply();
        editor.putInt("points_player2", 0);
        editor.apply();
        super.onDestroy();
    }
}