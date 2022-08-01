package com.example.fprograms5;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button phone,email,sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sms = findViewById(R.id.button);
        email = findViewById(R.id.button2);
        phone = findViewById(R.id.button3);

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS();
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendPhone();
            }
        });
    }

    private void sendPhone() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    private void sendEmail() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"abc"});
        intent.putExtra(Intent.EXTRA_SUBJECT,"yeehaw");
        intent.putExtra(Intent.EXTRA_TEXT,"yes");
        startActivity(intent);
    }

    private void sendSMS() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String p="7218081467";
        intent.setData(Uri.parse("sms:"+p));
        intent.putExtra(Intent.EXTRA_TEXT,"YES");
        startActivity(intent);
    }
}