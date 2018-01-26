package com.shrreya.diceroll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = findViewById(R.id.start_button);
        final EditText nameEditText = findViewById(R.id.name_edit_text);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                if(name.length() > 0) {
                    Intent gameIntent = new Intent(MainActivity.this, DiceActivity.class);
                    gameIntent.putExtra("NAME", name);
                    startActivity(gameIntent);
                } else {
                    Toast.makeText(MainActivity.this, R.string.name_error_msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
