package com.example.cxx.dsyklx;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.cxx.dsyklx.fragment.Frag01;
import com.example.cxx.dsyklx.fragment.Frag02;
import com.example.cxx.dsyklx.fragment.Frag03;
import com.example.cxx.dsyklx.fragment.Frag04;
import com.example.cxx.dsyklx.fragment.Frag05;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frame;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frame = findViewById(R.id.frame);
        rg = findViewById(R.id.rg);
        final FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame,new Frag01()).commit();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.btn_one:
                        manager.beginTransaction().replace(R.id.frame,new Frag01()).commit();
                        break;
                    case R.id.btn_two:
                        manager.beginTransaction().replace(R.id.frame,new Frag02()).commit();
                        break;
                    case R.id.btn_three:
                        manager.beginTransaction().replace(R.id.frame,new Frag03()).commit();
                        break;
                    case R.id.btn_foul:
                        manager.beginTransaction().replace(R.id.frame,new Frag04()).commit();
                        break;
                    case R.id.btn_five:
                        manager.beginTransaction().replace(R.id.frame,new Frag05()).commit();
                        break;
                }
            }
        });
    }
}
