package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView countDisplay;
    Button button;
    Button reset;
    Integer count = 0;
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countDisplay = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        reset = findViewById(R.id.button2);
        aSwitch = (Switch) findViewById(R.id.switch1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                countDisplay.setText("" + count);
            }
        });
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            count--;
                            countDisplay.setText("" + count);
                        }
                    });
                } else {
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            count++;
                            countDisplay.setText("" + count);
                        }
                    });
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                countDisplay.setText("" + count);
            }
        });
    }
}