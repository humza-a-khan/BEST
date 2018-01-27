package com.best.subtasks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.best.MainActivity;
import com.best.R;
import com.best.subtasks.RVE.RVEInstructions;

import java.text.SimpleDateFormat;
import java.util.Date;

// this class is called when starting BEST from CreateProfileActivity.
// the reason for this class is to return to MainActivity if back is pressed
//instead of going back to the profile creation screen.

public class StartBESTfromCreate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // hide the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_best);

        Bundle bundle = getIntent().getExtras();
        String date = (new SimpleDateFormat("MM/dd/yyyy HH:mm:SSS")).format(new Date());
        String id = "";

        if (bundle != null) {
            id = (String) bundle.get("id");
        }

        Intent intent = new Intent(this, RVEInstructions.class);
        intent.putExtra("bestDate", date);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    // return to main if resumed
    @Override
    protected void onRestart() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        super.onRestart();
    }
}