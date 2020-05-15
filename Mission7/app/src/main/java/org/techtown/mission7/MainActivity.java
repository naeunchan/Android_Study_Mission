package org.techtown.mission7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ID;
    EditText PW;
    private int REQUEST_NUM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String id = ID.getText().toString();
                String pw = PW.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("ID", id);
                intent.putExtra("PASSWORD", pw);

                startActivityForResult(intent, REQUEST_NUM);
            }
        });

        ID = (EditText)findViewById(R.id.editID);
        PW = (EditText)findViewById(R.id.editPW);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_NUM){
            if(data != null){
                String menu = data.getStringExtra("menu");
                String message =data.getStringExtra("message");

                Toast toast = Toast.makeText(getBaseContext(),"result code : " + resultCode + ", menu : " + menu + ", message : " + message, Toast.LENGTH_LONG);
                toast.show();
            }

        }
    }
}
