package com.estsoft.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_LABEL="MainActivity";

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_LABEL, "onStart Called...");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_LABEL, "OnCreate Called...");
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener( new View.OnClickListener() {
           @Override
           public void onClick( View v ) {
               Toast.makeText( getApplicationContext(), "clicked", Toast.LENGTH_LONG).show();
               TextView textView = (TextView)findViewById(R.id.textview);
               textView.setText(getResources().getString(R.string.message_clicked));
           }
        });
        button.setOnHoverListener(new View.OnHoverListener() {
            public boolean onHover(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_HOVER_ENTER:
                        TextView textView = (TextView)findViewById(R.id.textview);
                        textView.setText(getResources().getString(R.string.message_clicked));
                        break;
                    default :
                        TextView textView1 = (TextView) findViewById(R.id.textview);
                        textView1.setText(getResources().getString(R.string.message));
                        break;
                }
                return true;
            }
        });

    }
}
