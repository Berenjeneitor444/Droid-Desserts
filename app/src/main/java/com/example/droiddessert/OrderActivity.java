package com.example.droiddessert;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderActivity extends AppCompatActivity {

    private static final String TAG = OrderActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ((TextView)findViewById(R.id.order_name)).setText(getIntent().getStringExtra("chosen item"));
    }
    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        int id = view.getId();
        if (id == R.id.sameday) {
            if (checked)
                // Same day service
                displayToast(getString(R.string.chosen) + getString(R.string.same_day_messenger_service));
        } else if (id == R.id.nextday) {
            if (checked)
                // Next day service
                displayToast(getString(R.string.chosen) + getString(R.string.next_day_ground_delivery));
        } else if (id == R.id.pickup) {
            if (checked)
                // Pick up
                displayToast(getString(R.string.chosen) + getString(R.string.pick_up));
        } else {
            Log.d(TAG, getString(R.string.nothing_clicked));
        }
    }
}