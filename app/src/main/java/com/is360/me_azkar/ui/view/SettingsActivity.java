package com.is360.me_azkar.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.slider.Slider;
import com.is360.me_azkar.Adapter;
import com.is360.me_azkar.MainActivity;
import com.is360.me_azkar.R;

public class SettingsActivity extends AppCompatActivity {

    ImageView backIV;
    TextView showFontSize , textSampleTV;
    Slider fontChangeSlider;
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);
        try {
            this.getSupportActionBar().hide();
//            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } catch (NullPointerException e) {
        }
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        textSampleTV = findViewById(R.id.textSampleTV);
        fontChangeSlider = findViewById(R.id.fontChangeSlider);
        backIV = findViewById(R.id.backIV);
        aSwitch = findViewById(R.id.switchLanguage);


        SharedPreferences sharedPreferences = this.getSharedPreferences("save", Context.MODE_PRIVATE);
        float textSize = sharedPreferences.getFloat("font_size", 20f);
        textSampleTV.setTextSize(TypedValue.COMPLEX_UNIT_SP , textSize);
        fontChangeSlider.setValue(textSize);



        fontChangeSlider.addOnChangeListener(new Slider.OnChangeListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onValueChange(@NonNull Slider slider, float v, boolean b) {
                saveFontSize(v);
                textSampleTV.setTextSize(TypedValue.COMPLEX_UNIT_SP , v);
            }
        });

        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Save State in Shared Preferences
//        context = getApplicationContext();
//        SharedPreferences sharedPreferences = context.getSharedPreferences("save", context.MODE_PRIVATE);
        aSwitch.setChecked(sharedPreferences.getBoolean("value", false));

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aSwitch.isChecked()) {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", true);
                    editor.apply();
                    aSwitch.setText("English");
                    aSwitch.setChecked(true);
                    MainActivity.setLanguage(true);
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
                    editor.putBoolean("value", false);
                    aSwitch.setText("Urdu");
                    editor.apply();
                    aSwitch.setChecked(false);
                    MainActivity.setLanguage(false);
                }
            }
        });

        // for first time
        if(aSwitch.isChecked()) {
            MainActivity.setLanguage(true);
            aSwitch.setText("English");
        }
        else {
            MainActivity.setLanguage(false);
        }

    }

    private void saveFontSize(float fontSize) {
        SharedPreferences.Editor editor = getSharedPreferences("save", MODE_PRIVATE).edit();
        editor.putFloat("font_size",fontSize);
        editor.apply();
        Adapter.updateTextSize(fontSize);
    }
}