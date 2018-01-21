package com.example.attaln.tictactoe;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String xo;
    TextView title;
    Button restartBtn;
    List<Button> btns = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.title);


        btns.add((Button) findViewById(R.id.button1));
        btns.add((Button) findViewById(R.id.button2));
        btns.add((Button) findViewById(R.id.button3));
        btns.add((Button) findViewById(R.id.button4));
        btns.add((Button) findViewById(R.id.button5));
        btns.add((Button) findViewById(R.id.button6));
        btns.add((Button) findViewById(R.id.button7));
        btns.add((Button) findViewById(R.id.button8));
        btns.add((Button) findViewById(R.id.button9));
        restartBtn = (Button) findViewById(R.id.restart);
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newGame();
            }
        });

        for (Button btn : btns) {
            btn.setOnClickListener(this);
        }

        newGame();
    }

    private void newGame() {
        xo = "X";
        title.setText("Now Playing: " + xo);
        for(Button btn: btns) {
            btn.setText(null);
            btn.setTag(btns.indexOf(btn));
            btn.setClickable(true);
            btn.setTextColor(restartBtn.getTextColors());
        }
        restartBtn.setText("Restart");
    }

    @Override
    public void onClick(View view) {
        Button b = findViewById(view.getId());
        if (b.isClickable()) {
            b.setText(xo);
            b.setTag(xo);
            b.setClickable(false);
            xo = xo.equals("X") ? "O" : "X";
            title.setText("Now Playing: " + xo);

            checkWin();
        }
    }

    private void checkWin() {
        if (btns.get(0).getTag().equals(btns.get(1).getTag()) && btns.get(0).getTag().equals(btns.get(2).getTag())) {
            gameOver(btns.get(0), btns.get(1), btns.get(2));
        }
        if (btns.get(3).getTag().equals(btns.get(4).getTag()) && btns.get(3).getTag().equals(btns.get(5).getTag())) {
            gameOver(btns.get(3), btns.get(4), btns.get(5));
        }
        if (btns.get(6).getTag().equals(btns.get(7).getTag()) && btns.get(6).getTag().equals(btns.get(8).getTag())) {
            gameOver(btns.get(6), btns.get(7), btns.get(8));
        }
        if (btns.get(0).getTag().equals(btns.get(3).getTag()) && btns.get(0).getTag().equals(btns.get(6).getTag())) {
            gameOver(btns.get(0), btns.get(3), btns.get(6));
        }
        if (btns.get(1).getTag().equals(btns.get(4).getTag()) && btns.get(1).getTag().equals(btns.get(7).getTag())) {
            gameOver(btns.get(1), btns.get(4), btns.get(7));
        }
        if (btns.get(2).getTag().equals(btns.get(5).getTag()) && btns.get(2).getTag().equals(btns.get(8).getTag())) {
            gameOver(btns.get(2), btns.get(5), btns.get(8));
        }
        if (btns.get(0).getTag().equals(btns.get(4).getTag()) && btns.get(0).getTag().equals(btns.get(8).getTag())) {
            gameOver(btns.get(0), btns.get(4), btns.get(8));
        }
        if (btns.get(2).getTag().equals(btns.get(4).getTag()) && btns.get(2).getTag().equals(btns.get(6).getTag())) {
            gameOver(btns.get(2), btns.get(4), btns.get(6));
        }


    }

    private void gameOver(Button btn1, Button btn2, Button btn3) {
        btn1.setTextColor(Color.RED);
        btn2.setTextColor(Color.RED);
        btn3.setTextColor(Color.RED);

        for(Button btn: btns) {
            btn.setClickable(false);
        }

        title.setText("Game Over!");
        restartBtn.setText("New Game?");

    }
}

