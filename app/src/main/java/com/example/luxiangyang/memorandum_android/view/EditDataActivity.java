package com.example.luxiangyang.memorandum_android.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.luxiangyang.memorandum_android.R;
import com.example.luxiangyang.memorandum_android.viewmodel.EditViewModel;

/**
 * Created by 陆向阳 on 2018/12/10 12:59 PM
 */
public class EditDataActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        new EditViewModel(this);
    }

}
