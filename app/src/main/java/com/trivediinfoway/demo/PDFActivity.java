package com.trivediinfoway.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PDFActivity extends AppCompatActivity {

    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        tv = (TextView)findViewById(R.id.tv);
        tv.setText(getResources().getString(R.string.ag)) ;

    }
}
