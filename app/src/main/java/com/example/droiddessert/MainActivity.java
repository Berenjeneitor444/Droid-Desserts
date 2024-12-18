package com.example.droiddessert;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.example.droiddessert.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String chosenItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.droiddessert.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(view -> showFoodOrder(chosenItem));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem favoriteItem = menu.findItem(R.id.favorites);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            favoriteItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        }
        else{
            favoriteItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
        }
        return super.onPrepareOptionsMenu(menu);
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
        displayToast(getString(R.string.donut_order_message));
        chosenItem = getString(R.string.donut_order_message);
    }

    public void showIceCreamOrder(View view) {
        displayToast(getString(R.string.ice_cream_order_message));
        chosenItem = getString(R.string.ice_cream_order_message);
    }

    public void showFroyoOrder(View view) {
        displayToast(getString(R.string.froyo_order_message));
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
        else{
            displayToast(getString(R.string.no_order_message));
        }


    }
}