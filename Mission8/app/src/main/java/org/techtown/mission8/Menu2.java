package org.techtown.mission8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu2 extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU2= 1002;
    public static final int REQUEST_CODE_EXIT = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        Button menuButton = (Button)findViewById(R.id.menuButton);
        Button loginButton = (Button)findViewById(R.id.loginButton);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("menu", "매출 관리 메뉴");
                resultIntent.putExtra("message", "It's from MENU2!");

                setResult(REQUEST_CODE_MENU2, resultIntent);
                finish();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("menu", "매출 관리 메뉴");
                resultIntent.putExtra("message", "It's from MENU2!");

                setResult(REQUEST_CODE_EXIT, resultIntent);
                finish();
            }
        });
    }
}
