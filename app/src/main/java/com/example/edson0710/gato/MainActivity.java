package com.example.edson0710.gato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        if(!((Button) v).getText().toString().equals("")){
            return;
        }

        if(turno1){
            ((Button)v).setText("X");
        } else{
            ((Button)v).setText("O");
        }

        rondascont++;

        if(Ganador()){
            if(turno1){
                gano1();
            } else{
                gano2();
            }
        } else if(rondascont == 9){
            draw();
        } else{
            turno1 = !turno1;
        }
    }

    private boolean Ganador(){
        String[][] field = new String[3][3];

        for(int i = 0;i < 3; i++) {
            for(int j = 0;j < 3; j++){
                field[i][j] = botones[i][j].getText().toString();
            }
        }

        for(int i = 0;i < 3;i++){
            if(field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")){
                return true;
            }
        }

        for(int i = 0;i < 3;i++){
            if(field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")){
                return true;
            }
        }

        if(field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")){
            return true;
        }

        if(field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")){
            return true;
        }

        return false;
    }

    private void gano1(){
        Puntos1++;
        Toast.makeText(this, "Jugador 1 es el Ganador", Toast.LENGTH_SHORT).show();
        updatePuntos();
        restTablero();
    }

    private void gano2(){
        Puntos2++;
        Toast.makeText(this, "Jugador 2 es el Ganador", Toast.LENGTH_SHORT).show();
        updatePuntos();
        restTablero();
    }

    private void draw() {
        Toast.makeText(this, "Empate!", Toast.LENGTH_SHORT).show();
        restTablero();
    }

    private void updatePuntos() {
        j1.setText("Jugador 1: " + Puntos1);
        j2.setText("Jugador 2: " + Puntos2);
    }

    private void restTablero() {
        for(int i = 0; i < 3;i++){
            for(int j = 0;j<3;j++){
              botones[i][j].setText("");
            }
        }
        rondascont = 0;
        turno1 = true;
    }


}

