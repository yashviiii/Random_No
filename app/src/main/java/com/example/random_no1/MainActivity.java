package com.example.random_no1;

import androidx.annotation.ContentView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Min, Max, Avg, N;
    TextView TV;
    Button button;
    boolean isKeyboardShowing = false;
    ContentView contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Min = findViewById(R.id.MinVal);
        Max = findViewById(R.id.MaxVal);
        Avg = findViewById(R.id.AvgVal);
        N = findViewById(R.id.Number);
        TV = findViewById(R.id.textView);
        button = findViewById(R.id.button2);
        TV.setTextIsSelectable(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double sum = 0, f;
                int min = Integer.parseInt(Min.getText().toString());
                int max = Integer.parseInt(Max.getText().toString());
                double avg = Double.parseDouble(Avg.getText().toString());
                int n = Integer.parseInt(N.getText().toString());
                StringBuilder str = new StringBuilder();
                /*for(int i=1;i<=n;i++)
                {
                    if(i==n)
                    {
                        f=i*avg-sum;
                    }
                    else if(i%2==0)
                    {
                        f = i*avg-sum;
                    }
                    else
                    {
                        f = min + Math.random() * (max - min);
                    }
                    str.append(f+"\n");
                    sum=sum+f;
                }*/
                for (int i = 1; i <= n; i++) {
                    if (i == n / 2 || i == n) {
                        f = i * avg - sum;
                    } else if (i % 2 == 0) {
                        f = min + Math.random() * (avg - min);
                    } else {
                        f = avg + Math.random() * (max - avg);
                    }
                    str.append(String.format("%.4f", f) + "\n");
                    sum = sum + f;
                }
                TV.setText(str);
            }
        });
    }
}