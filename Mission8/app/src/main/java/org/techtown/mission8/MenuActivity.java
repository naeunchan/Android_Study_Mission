package org.techtown.mission8;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;
    public static final int REQUEST_CODE_MENU1 = 1001;
    public static final int REQUEST_CODE_MENU2 = 1002;
    public static final int REQUEST_CODE_MENU3 = 1003;
    public static final int REQUEST_CODE_EXIT1 = 11;
    public static final int REQUEST_CODE_EXIT2 = 12;
    public static final int REQUEST_CODE_EXIT3 = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        String id = intent.getStringExtra("ID");
        String pw = intent.getStringExtra("PASSWORD");

        Toast.makeText(this,"ID : " + id + ", PASSWORD : " + pw, Toast.LENGTH_LONG).show();

        Button button = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent(getApplicationContext(), Menu1.class);
                startActivityForResult(resultIntent, REQUEST_CODE_MENU);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent(getApplicationContext(), Menu2.class);
                resultIntent.putExtra("menu", "매출관리 메뉴");
                resultIntent.putExtra("message", "result message is OK!");

                startActivityForResult(resultIntent, REQUEST_CODE_MENU);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent(getApplicationContext(), Menu3.class);
                resultIntent.putExtra("menu", "상품관리 메뉴");
                resultIntent.putExtra("message", "result message is OK!");

                startActivityForResult(resultIntent, REQUEST_CODE_MENU);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_MENU) {
            if (data != null) {
                if (resultCode == REQUEST_CODE_MENU1 || resultCode == REQUEST_CODE_MENU2 || resultCode == REQUEST_CODE_MENU3) {
                    String menu = data.getStringExtra("menu");
                    String message = data.getStringExtra("message");

                    Toast.makeText(this, "result code : " + resultCode + " menu : " + menu + " message : " + message, Toast.LENGTH_LONG).show();
                }
                else if (resultCode == REQUEST_CODE_EXIT1 || resultCode == REQUEST_CODE_EXIT2 || resultCode == REQUEST_CODE_EXIT3) {
                    setResult(resultCode, data);
                    finish();
                }
            }
        }
    }
}
