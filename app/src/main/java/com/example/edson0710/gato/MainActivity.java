package com.example.edson0710.gato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] botones = new Button[3][3];

    private boolean turno1 = true;

    private int rondascont;

    private int Puntos1;
    private int Puntos2;

    private TextView j1;
    private TextView j2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        j1 = findViewById(R.id.j1);
        j2 = findViewById(R.id.j2);

        for (int i = 0;i < 3;i++) {
            for(int j = 0;j < 3;j++) {
                String buttonID = "btn_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id",getPackageName());
                botones[i][j] = findViewById(resID);
                botones[i][j].setOnClickListener(this);
            }
        }

        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        }

    @Override
    public void onClick(View v) {
        if(!((Button) v).getText().toString().equals(""))
    }
}

