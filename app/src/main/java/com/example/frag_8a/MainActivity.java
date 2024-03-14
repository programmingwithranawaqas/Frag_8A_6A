package com.example.frag_8a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements ListFrag.NameSelected {

    ArrayList<String> numbers;
    TextView tvNumber;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numbers = new ArrayList<>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");

        manager = getSupportFragmentManager();

        tvNumber = Objects.requireNonNull(manager.findFragmentById(R.id.detailfrag)).requireView()
                .findViewById(R.id.tvNumber);

        tvNumber.setText(numbers.get(0));

    }

    @Override
    public void onNameClick(int position) {
        tvNumber.setText(numbers.get(position));
    }
}