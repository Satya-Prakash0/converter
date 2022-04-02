package com.example.python_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {
      EditText input1,input2;
      Button button;
      TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1=findViewById(R.id.input1);
        input2=findViewById(R.id.input2);
        button=findViewById(R.id.button);
        textView=findViewById(R.id.textView);

        if(!Python.isStarted())
            Python.start(new AndroidPlatform(this));

        Python py=Python.getInstance();
        PyObject pyObject=py.getModule("script");  //name of the python file

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                   //function name     //first argument     //second argument
                PyObject obj=pyObject.callAttr("main");
              // PyObject obj = pyObject.callAttr("translator", 5);
                    textView.setText(obj.toString());

            }
        });

    }
}