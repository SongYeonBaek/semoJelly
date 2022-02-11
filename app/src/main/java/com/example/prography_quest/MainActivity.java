package com.example.prography_quest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.ViewDebug;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();

    private Fragment_byscore fragment_byscore = new Fragment_byscore();
    private Fragment_bytitle fragment_bytitle = new Fragment_bytitle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationview);

        //첫화면 지정
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragment_byscore).commitAllowingStateLoss();

        //bottomNavigationView의 아이템이 선택될때 호출될 리스너
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                switch (item.getItemId()){
                    case R.id.byscore: {
                        transaction.replace(R.id.frameLayout, fragment_byscore).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.bytitle: {
                        transaction.replace(R.id.frameLayout, fragment_bytitle).commitAllowingStateLoss();
                        break;
                    }
                }
                return true;
            }
        });
    }


}