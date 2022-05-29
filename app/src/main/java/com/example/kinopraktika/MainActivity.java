package com.example.kinopraktika;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        // добавляем пункты меню
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Intent intent =null;
        switch (item.getItemId())
        {
            case R.id.m1: intent = new Intent(this, Second_AC.class);
                break;
            case R.id.m2: intent = new Intent(this, Post.class);
                break;
            case R.id.m3: intent = new Intent(this, ADDFilms.class);
                break;
            case R.id.m4: intent = new Intent(this, fiveact.class);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
    public void poiskkinot(View v){
     Intent intent = new Intent(this,Second_AC.class);
     startActivity(intent);
    }
    public void poiskfilma(View v){
        Intent intent = new Intent(this,fiveact.class);
        startActivity(intent);
    }
    public void Newkinot(View v){
        Intent intent = new Intent(this,Post.class);
        startActivity(intent);
    }
    public void Newfilm(View v){
        Intent intent = new Intent(this,ADDFilms.class);
        startActivity(intent);
    }
}


