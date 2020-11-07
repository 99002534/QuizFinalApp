package com.example.nisganbini.quizbee;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FinalActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    ArrayList<MainModel> mainModels;
    FinalAdapter finalAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        recyclerView=findViewById(R.id.recyclerview);
        Integer[] langLogo={R.drawable.angular,R.drawable.react,R.drawable.csharp,R.drawable.flutter,R.drawable.go,R.drawable.java,R.drawable.python,R.drawable.ruby,R.drawable.swift,R.drawable.ts};
        String[] langName={"Angular","React","C++","flutter","go","java","python","ruby","swift","typescript"};

        mainModels=new ArrayList<>();
        for (int i=0;i<langLogo.length;i++){
            MainModel model=new MainModel(langLogo[i],langName[i]);
            mainModels.add(model);
        }

        LinearLayoutManager layoutManager=new LinearLayoutManager(
                FinalActivity.this,LinearLayoutManager.HORIZONTAL,false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        finalAdapter =new FinalAdapter(FinalActivity.this,mainModels);
        recyclerView.setAdapter(finalAdapter);


    }
}