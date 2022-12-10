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

public class GameActivity extends AppCompatActivity {

    ImageView imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6, imageButton7, imageButton8, imageButton9, move;
    TextView issue_message, points_player1, points_player2;
    Button restartGame;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int cross, zero, sign, nextMove, NullBack, pointsOfPlayer1, pointsOfPlayer2;
    String str_sign;
    int clicked_button;
    int current_move = 1, tempMove = current_move;
    int moving1 = 0, moving2 = 0, moving3 = 0, moving4 = 0, moving5 = 0, moving6 = 0, moving7 = 0, moving8 = 0, moving9 = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        move = findViewById(R.id.current_move);

        imageButton1 = findViewById(R.id.imageView1);
        imageButton2 = findViewById(R.id.imageView2);
        imageButton3 = findViewById(R.id.imageView3);
        imageButton4 = findViewById(R.id.imageView4);
        imageButton5 = findViewById(R.id.imageView5);
        imageButton6 = findViewById(R.id.imageView6);
        imageButton7 = findViewById(R.id.imageView7);
        imageButton8 = findViewById(R.id.imageView8);
        imageButton9 = findViewById(R.id.imageView9);

        zero = R.drawable.zero;
        cross = R.drawable.cross;
        NullBack = R.drawable.whiteback;
        restartGame = findViewById(R.id.restartGame);

        issue_message = findViewById(R.id.issue_message);
        points_player1 = findViewById(R.id.points_player1);
        points_player2 = findViewById(R.id.points_player2);

        if(current_move == 1) {
            move.setImageResource(cross);
        }
        else if (current_move == 2) {
            move.setImageResource(zero);
        }

        sharedPreferences = this.getSharedPreferences("crossZero", Context.MODE_PRIVATE);//сохранение данных
        editor = sharedPreferences.edit();
        pointsOfPlayer1 = sharedPreferences.getInt("points_player1", 0);
        points_player1.setText("" + pointsOfPlayer1);
        pointsOfPlayer2 = sharedPreferences.getInt("points_player2", 0);
        points_player2.setText("" + pointsOfPlayer2);
    }

    public void button_click (View view) {
        clicked_button = view.getId();
        if(tempMove % 2 == 1) {
            sign = cross;
            nextMove = zero;
            str_sign = "cross";
        }
        else {
            sign = zero;
            nextMove = cross;
            str_sign = "zero";
        }

        switch (clicked_button) {
            case R.id.imageView1:
                moving1 = PlayerMove(moving1, imageButton1, move, sign, str_sign);
                break;

            case R.id.imageView2:
                moving2 = PlayerMove(moving2, imageButton2, move, sign, str_sign);
                break;

            case R.id.imageView3:
                moving3 = PlayerMove(moving3, imageButton3, move, sign, str_sign);
                break;

            case R.id.imageView4:
                moving4 = PlayerMove(moving4, imageButton4, move, sign, str_sign);
                break;

            case R.id.imageView5:
                moving5 = PlayerMove(moving5, imageButton5, move, sign, str_sign);
                break;

            case R.id.imageView6:
                moving6 = PlayerMove(moving6, imageButton6, move, sign, str_sign);
                break;

            case R.id.imageView7:
                moving7 = PlayerMove(moving7, imageButton7, move, sign, str_sign);
                break;

            case R.id.imageView8:
                moving8 = PlayerMove(moving8, imageButton8, move, sign, str_sign);
                break;

            case R.id.imageView9:
                moving9 = PlayerMove(moving9, imageButton9, move, sign, str_sign);
                break;
        }
    }

    public int PlayerMove (int moving, ImageView imageButton, ImageView Move, int Sign, String Str_sign) {
        if (moving == 0) {
            Move.setImageResource(nextMove);
            imageButton.setImageResource(Sign);
            imageButton.setTag(Str_sign);
            isPlayerWinner();
            tempMove ++;
            return 1;
        }
        else {
            return moving;
        }
    }

    public void isPlayerWinner () {
        if(imageButton1.getTag() == imageButton2.getTag() && imageButton1.getTag() == imageButton3.getTag() && imageButton1.getTag() != null) {
            Who_Winner((String) imageButton1.getTag());
        }
        else if(imageButton4.getTag() == imageButton5.getTag() && imageButton4.getTag() == imageButton6.getTag() && imageButton4.getTag() != null) {
            Who_Winner((String) imageButton4.getTag());
        }
        else if(imageButton7.getTag() == imageButton8.getTag() && imageButton7.getTag() == imageButton9.getTag() && imageButton7.getTag() != null) {
            Who_Winner((String) imageButton7.getTag());
        }

        else if(imageButton1.getTag() == imageButton4.getTag() && imageButton1.getTag() == imageButton7.getTag() && imageButton1.getTag() != null) {
            Who_Winner((String) imageButton1.getTag());
        }
        else if(imageButton2.getTag() == imageButton5.getTag() && imageButton2.getTag() == imageButton8.getTag() && imageButton2.getTag() != null) {
            Who_Winner((String) imageButton2.getTag());
        }
        else if(imageButton3.getTag() == imageButton6.getTag() && imageButton3.getTag() == imageButton9.getTag() && imageButton3.getTag() != null) {
            Who_Winner((String) imageButton3.getTag());
        }

        else if(imageButton1.getTag() == imageButton5.getTag() && imageButton1.getTag() == imageButton9.getTag() && imageButton1.getTag() != null) {
            Who_Winner((String) imageButton1.getTag());
        }
        else if(imageButton3.getTag() == imageButton5.getTag() && imageButton3.getTag() == imageButton7.getTag() && imageButton3.getTag() != null) {
            Who_Winner((String) imageButton3.getTag());
        }

        else if(imageButton1.getTag() != null && imageButton2.getTag() != null && imageButton3.getTag() != null &&
                imageButton4.getTag() != null && imageButton5.getTag() != null && imageButton6.getTag() != null &&
                imageButton7.getTag() != null && imageButton8.getTag() != null && imageButton9.getTag() != null) {

            issue_message.setText(getText(R.string.draw_massage).toString());
            move.setImageResource(0);
            restartGame.setVisibility(View.VISIBLE);
        }
    }

    public void Who_Winner (String last_sign) {
        if (last_sign.equals("cross")) {
            issue_message.setText(getText(R.string.winner_massage_to_player1).toString());
            move.setImageResource(cross);
            pointsOfPlayer1++;

        }
        else if (last_sign.equals("zero")) {
            issue_message.setText(getText(R.string.winner_massage_to_player2).toString());
            move.setImageResource(zero);
            pointsOfPlayer2++;
        }
        moving1 = 1;
        moving2 = 1;
        moving3 = 1;
        moving4 = 1;
        moving5 = 1;
        moving6 = 1;
        moving7 = 1;
        moving8 = 1;
        moving9 = 1;
        restartGame.setVisibility(View.VISIBLE);
    }

    public void clickRestart (View view) {
        Move(current_move);
        issue_message.setText("");
        moving1 = resetPlayingField(imageButton1);
        moving2 = resetPlayingField(imageButton2);
        moving3 = resetPlayingField(imageButton3);
        moving4 = resetPlayingField(imageButton4);
        moving5 = resetPlayingField(imageButton5);
        moving6 = resetPlayingField(imageButton6);
        moving7 = resetPlayingField(imageButton7);
        moving8 = resetPlayingField(imageButton8);
        moving9 = resetPlayingField(imageButton9);
        points_player1.setText("" + pointsOfPlayer1);
        points_player2.setText("" + pointsOfPlayer2);
        editor.putInt("points_player1", pointsOfPlayer1);
        editor.apply();
        editor.putInt("points_player2", pointsOfPlayer2);
        editor.apply();
        restartGame.setVisibility(View.INVISIBLE);
    }

    public int resetPlayingField(ImageView imageButton) {
        imageButton.setImageResource(0);
        imageButton.setTag(null);
        return 0;
    }

    public void Move (int curMove) {
        if (curMove == 1) {
            current_move = 2;
            move.setImageResource(zero);
        }
        else {
            current_move = 1;
            move.setImageResource(cross);
        }
        tempMove = current_move;
    }

    public void click_back(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GameActivity.this, ChoiseGameMode.class);
        startActivity(intent);
        finish();
    }
}