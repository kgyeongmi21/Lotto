package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(v -> {
            updateLotto();
        });
    }

    private void updateLotto() {
        List<Integer> arr = makeNewLotto();
        binding.textNum1.setText(arr.get(0).toString());
        binding.textNum2.setText(arr.get(1).toString());
        binding.textNum3.setText(arr.get(2).toString());
        binding.textNum4.setText(arr.get(3).toString());
        binding.textNum5.setText(arr.get(4).toString());
        binding.textNum6.setText(arr.get(5).toString());
    }

    private List<Integer> makeNewLotto() {
        ArrayList<Integer> array = new ArrayList<>();

        while (array.size() != 6) {
            int nextValue = random.nextInt(45) + 1;
            Log.i("realone", String.format("random value is %d", nextValue));
            if (!array.contains(nextValue)) {
                array.add(nextValue);
            } else {
                Log.i("realone", "중복이라 다시 뽑는다");
            }
        }
        Collections.sort(array);
        return array;
    }
}