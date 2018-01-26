package com.shrreya.diceroll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");

        TextView nameTextView = findViewById(R.id.name_text_view);
        final ImageView diceOne = findViewById(R.id.dice_one);
        final ImageView diceTwo = findViewById(R.id.dice_two);
        Button rollButton = findViewById(R.id.roll_button);

        String msg = getString(R.string.hello_msg) + " " + name;
        nameTextView.setText(msg);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value1 = randomDiceValue();
                int value2 = randomDiceValue();

                int res1 = getResources().getIdentifier("dice_" + value1, "drawable", "com.shrreya.diceroll");
                int res2 = getResources().getIdentifier("dice_" + value2, "drawable", "com.shrreya.diceroll");

                diceOne.setImageResource(res1);
                diceTwo.setImageResource(res2);

                if(value1 + value2 == 12) {
                    Toast.makeText(DiceActivity.this, R.string.lucky_draw_msg, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public static int randomDiceValue() {
        return (int) (Math.random() * 6 + 1);
    }
}
