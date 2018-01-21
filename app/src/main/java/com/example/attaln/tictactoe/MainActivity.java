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
    List<Button> buttons = new LinkedList<>();
    int moves;
    boolean gameWon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.title);


        buttons.add((Button) findViewById(R.id.button1));
        buttons.add((Button) findViewById(R.id.button2));
        buttons.add((Button) findViewById(R.id.button3));
        buttons.add((Button) findViewById(R.id.button4));
        buttons.add((Button) findViewById(R.id.button5));
        buttons.add((Button) findViewById(R.id.button6));
        buttons.add((Button) findViewById(R.id.button7));
        buttons.add((Button) findViewById(R.id.button8));
        buttons.add((Button) findViewById(R.id.button9));
        restartBtn = (Button) findViewById(R.id.restart);
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newGame();
            }
        });

        for (Button btn : buttons) {
            btn.setOnClickListener(this);
        }

        newGame();
    }

    private void newGame() {
        moves = 0;
        xo = "X";
        gameWon = false;
        title.setText(xo + " Turn");
        for (Button btn : buttons) {
            btn.setText(null);
            btn.setTag(buttons.indexOf(btn));
            btn.setClickable(true);
            btn.setTextColor(restartBtn.getTextColors());
        }
        restartBtn.setText("Restart");
    }

    @Override
    public void onClick(View view) {
        Button b = findViewById(view.getId());
        if (b.isClickable()) {
            moves++;
            b.setText(xo);
            b.setTag(xo);
            b.setClickable(false);
            xo = xo.equals("X") ? "O" : "X";
            title.setText(xo + " Turn");

            if (moves >= 5) checkWin();
            if (moves == 9 && !gameWon) {
                title.setText("Tie!");
                restartBtn.setText("New Game?");
            }
        }
    }

    private void checkWin() {
        if (buttons.get(0).getTag().equals(buttons.get(1).getTag()) && buttons.get(0).getTag().equals(buttons.get(2).getTag())) {
            gameWon(buttons.get(0), buttons.get(1), buttons.get(2));
        }
        if (buttons.get(3).getTag().equals(buttons.get(4).getTag()) && buttons.get(3).getTag().equals(buttons.get(5).getTag())) {
            gameWon(buttons.get(3), buttons.get(4), buttons.get(5));
        }
        if (buttons.get(6).getTag().equals(buttons.get(7).getTag()) && buttons.get(6).getTag().equals(buttons.get(8).getTag())) {
            gameWon(buttons.get(6), buttons.get(7), buttons.get(8));
        }
        if (buttons.get(0).getTag().equals(buttons.get(3).getTag()) && buttons.get(0).getTag().equals(buttons.get(6).getTag())) {
            gameWon(buttons.get(0), buttons.get(3), buttons.get(6));
        }
        if (buttons.get(1).getTag().equals(buttons.get(4).getTag()) && buttons.get(1).getTag().equals(buttons.get(7).getTag())) {
            gameWon(buttons.get(1), buttons.get(4), buttons.get(7));
        }
        if (buttons.get(2).getTag().equals(buttons.get(5).getTag()) && buttons.get(2).getTag().equals(buttons.get(8).getTag())) {
            gameWon(buttons.get(2), buttons.get(5), buttons.get(8));
        }
        if (buttons.get(0).getTag().equals(buttons.get(4).getTag()) && buttons.get(0).getTag().equals(buttons.get(8).getTag())) {
            gameWon(buttons.get(0), buttons.get(4), buttons.get(8));
        }
        if (buttons.get(2).getTag().equals(buttons.get(4).getTag()) && buttons.get(2).getTag().equals(buttons.get(6).getTag())) {
            gameWon(buttons.get(2), buttons.get(4), buttons.get(6));
        }
    }

    private void gameWon(Button btn1, Button btn2, Button btn3) {
        gameWon = true;
        btn1.setTextColor(Color.RED);
        btn2.setTextColor(Color.RED);
        btn3.setTextColor(Color.RED);

        for (Button btn : buttons) {
            btn.setClickable(false);
        }

        title.setText(xo.equals("X") ? "O WON!" : "X WON!");
        restartBtn.setText("New Game?");

    }
}

