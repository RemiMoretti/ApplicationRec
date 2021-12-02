package com.example.myrecc;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myrecc.databinding.ActivityMainBinding;

public class DetailSoiree extends AppCompatActivity {
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_detail_soiree);

        TextView tvDescSoiree = findViewById(R.id.tvDescSoiree);

        //Button retour = findViewById(R.id.btRetourMenu);
        Bundle extra = getIntent().getExtras();

        tvDescSoiree.setText(extra.getString("tvDescription"));


    }
}
