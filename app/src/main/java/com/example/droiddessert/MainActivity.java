package com.example.droiddessert;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.example.droiddessert.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String chosenItem;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFoodOrder(chosenItem);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.order) {
            showFoodOrder(chosenItem);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void showDonutOrder(View view) {
        chosenItem = getString(R.string.donut_order_message);
    }

    public void showIceCreamOrder(View view) {
        chosenItem = getString(R.string.ice_cream_order_message);
    }

    public void showFroyoOrder(View view) {
        chosenItem = getString(R.string.froyo_order_message);
    }
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    public void showFoodOrder(String message){
        if (chosenItem != null){
            Intent intent = new Intent(this,OrderActivity.class);
            intent.putExtra("chosen item",message);
            startActivity(intent);
        }

    }
}