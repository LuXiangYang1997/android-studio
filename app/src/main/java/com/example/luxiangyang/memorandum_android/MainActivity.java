package com.example.luxiangyang.memorandum_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.luxiangyang.memorandum_android.adapter.ListDataAdapter;
import com.example.luxiangyang.memorandum_android.viewmodel.DataViewModel;

public class MainActivity extends AppCompatActivity {

    private DataViewModel dataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListDataAdapter listDataAdapter = new ListDataAdapter(this);

        dataViewModel = new DataViewModel(this,listDataAdapter);

    }


    @Override
    protected void onResume() {
        super.onResume();
        dataViewModel.initData();
    }
}
