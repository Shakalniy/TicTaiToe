package com.example.tictaitoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;
import java.util.Random;

public class GameVsComputer extends AppCompatActivity {

    String Difficulty, S_cross = "cross", S_zero = "zero";
    ImageView imageField1, imageField2, imageField3, imageField4, imageField5, imageField6, imageField7, imageField8, imageField9, move;
    TextView issue_message, points_player, points_computer;
    Button restartGame;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int cross, zero, NullBack, PointsOfPlayer, PointsOfComputer;
    int current_move = 1, tempMove = current_move;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_vs_computer);

        imageField1 = findViewById(R.id.field1);
        imageField2 = findViewById(R.id.field2);
        imageField3 = findViewById(R.id.field3);
        imageField4 = findViewById(R.id.field4);
        imageField5 = findViewById(R.id.field5);
        imageField6 = findViewById(R.id.field6);
        imageField7 = findViewById(R.id.field7);
        imageField8 = findViewById(R.id.field8);
        imageField9 = findViewById(R.id.field9);

        imageField1.setTag(null);
        imageField2.setTag(null);
        imageField3.setTag(null);
        imageField4.setTag(null);
        imageField5.setTag(null);
        imageField6.setTag(null);
        imageField7.setTag(null);
        imageField8.setTag(null);
        imageField9.setTag(null);

        zero = R.drawable.zero;
        cross = R.drawable.cross;
        NullBack = R.drawable.whiteback;

        issue_message = findViewById(R.id.issue_message);
        issue_message.setText("");
        points_player = findViewById(R.id.points_player);
        points_computer = findViewById(R.id.points_computer);
        restartGame = findViewById(R.id.restartGame);

        sharedPreferences = this.getSharedPreferences("crossZero", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        Difficulty = sharedPreferences.getString("difficult", "");
        PointsOfPlayer = sharedPreferences.getInt("points_player", 0);
        points_player.setText("" + PointsOfPlayer);
        PointsOfComputer = sharedPreferences.getInt("points_computer", 0);
        points_computer.setText("" + PointsOfComputer);
    }



    public void button_click (View view) {

        switch (view.getId()) {
            case R.id.field1:
                PlayerClick(imageField1, cross, S_cross);
                break;
            case R.id.field2:
                PlayerClick(imageField2, cross, S_cross);
                break;
            case R.id.field3:
                PlayerClick(imageField3, cross, S_cross);
                break;
            case R.id.field4:
                PlayerClick(imageField4, cross, S_cross);
                break;
            case R.id.field5:
                PlayerClick(imageField5, cross, S_cross);
                break;
            case R.id.field6:
                PlayerClick(imageField6, cross, S_cross);
                break;
            case R.id.field7:
                PlayerClick(imageField7, cross, S_cross);
                break;
            case R.id.field8:
                PlayerClick(imageField8, cross, S_cross);
                break;
            case R.id.field9:
                PlayerClick(imageField9, cross, S_cross);
                break;
        }
    }

    public void PlayerClick(ImageView imageField, int sign, String S_sign) {
        if (imageField.getTag() == null) {
            imageField.setImageResource(sign);
            imageField.setTag(S_sign);
            isWinner(S_sign);
            if(issue_message.getText() == "") {
                tempMove ++;
                computerTurn();
            }
        }
    }

    public void computerTurn(){
        if(Objects.equals(Difficulty, "easy")) {
            easyComputer();
        }
        else if(Objects.equals(Difficulty, "medium")) {
            mediumComputer();
        }
        else if(Objects.equals(Difficulty, "hard")) {
            hardComputer();
        }
        else if(Objects.equals(Difficulty, "god")) {
            godComputer();
        }
    }

    public void easyComputer() {
        Random random = new Random();
        int button_computer_click = 1 + random.nextInt(9);
        switch (button_computer_click) {
            case 1:
                computerClick(imageField1, zero, S_zero);
                break;
            case 2:
                computerClick(imageField2, zero, S_zero);
                break;
            case 3:
                computerClick(imageField3, zero, S_zero);
                break;
            case 4:
                computerClick(imageField4, zero, S_zero);
                break;
            case 5:
                computerClick(imageField5, zero, S_zero);
                break;
            case 6:
                computerClick(imageField6, zero, S_zero);
                break;
            case 7:
                computerClick(imageField7, zero, S_zero);
                break;
            case 8:
                computerClick(imageField8, zero, S_zero);
                break;
            case 9:
                computerClick(imageField9, zero, S_zero);
                break;
        }
    }

    public void mediumComputer() {

    }

    public void hardComputer() {

    }

    public void godComputer() {

    }

    public void computerClick(ImageView imageField, int sign, String S_sign) {
        if (imageField.getTag() == null) {
            imageField.setImageResource(sign);
            imageField.setTag(S_sign);
            isWinner(S_sign);
            tempMove ++;
        }
        else {
            computerTurn();
        }
    }

    public void isWinner(String tag) {
        if (imageField1.getTag() == tag && imageField2.getTag() == tag && imageField3.getTag() == tag) {
            whoWinner(tag);
        }
        else if (imageField4.getTag() == tag && imageField5.getTag() == tag && imageField6.getTag() == tag) {
            whoWinner(tag);
        }
        else if (imageField7.getTag() == tag && imageField8.getTag() == tag && imageField9.getTag() == tag) {
            whoWinner(tag);
        }

        else if (imageField1.getTag() == tag && imageField4.getTag() == tag && imageField7.getTag() == tag) {
            whoWinner(tag);
        }
        else if (imageField2.getTag() == tag && imageField5.getTag() == tag && imageField8.getTag() == tag) {
            whoWinner(tag);
        }
        else if (imageField3.getTag() == tag && imageField6.getTag() == tag && imageField9.getTag() == tag) {
            whoWinner(tag);
        }

        else if (imageField1.getTag() == tag && imageField5.getTag() == tag && imageField9.getTag() == tag) {
            whoWinner(tag);
        }
        else if (imageField3.getTag() == tag && imageField5.getTag() == tag && imageField7.getTag() == tag) {
            whoWinner(tag);
        }

        else if (imageField1.getTag() != null && imageField2.getTag() != null && imageField3.getTag() != null &&
                imageField4.getTag() != null && imageField5.getTag() != null && imageField6.getTag() != null &&
                imageField7.getTag() != null && imageField8.getTag() != null && imageField9.getTag() != null) {

            issue_message.setText(R.string.draw_massage);
            restartGame.setVisibility(View.VISIBLE);
        }
    }

    public void whoWinner(String tag) {
        if (Objects.equals(tag, S_cross)) {
            issue_message.setText(R.string.winner_massage_to_Player);
            PointsOfPlayer++;
            restartGame.setVisibility(View.VISIBLE);
        }
        else if (Objects.equals(tag, S_zero)){
            issue_message.setText(R.string.lose_massage_to_Player);
            restartGame.setVisibility(View.VISIBLE);
            PointsOfComputer++;
        }
        imageField1.setTag("fill");
        imageField2.setTag("fill");
        imageField3.setTag("fill");
        imageField4.setTag("fill");
        imageField5.setTag("fill");
        imageField6.setTag("fill");
        imageField7.setTag("fill");
        imageField8.setTag("fill");
        imageField9.setTag("fill");
    }

    public void restart(View view) {
        Move(current_move);
        resetPlayingField(imageField1);
        resetPlayingField(imageField2);
        resetPlayingField(imageField3);
        resetPlayingField(imageField4);
        resetPlayingField(imageField5);
        resetPlayingField(imageField6);
        resetPlayingField(imageField7);
        resetPlayingField(imageField8);
        resetPlayingField(imageField9);
        issue_message.setText("");
        points_player.setText("" + PointsOfPlayer);
        points_computer.setText("" + PointsOfComputer);
        editor.putInt("points_player", PointsOfPlayer);
        editor.apply();
        editor.putInt("points_computer", PointsOfComputer);
        editor.apply();
        restartGame.setVisibility(View.INVISIBLE);
    }

    public void Move(int currMove) {
        if(currMove == 1) {
            current_move = 2;
        }
        else if (currMove == 2) {
            current_move = 1;
        }
        tempMove = current_move;
    }

    public void resetPlayingField(ImageView imageField) {
        imageField.setImageResource(0);
        imageField.setTag(null);
    }

    public void click_back(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GameVsComputer.this, GameActivityWithComputer.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        editor.putInt("points_player", 0);
        editor.apply();
        editor.putInt("points_computer", 0);
        editor.apply();
        super.onDestroy();
    }
}