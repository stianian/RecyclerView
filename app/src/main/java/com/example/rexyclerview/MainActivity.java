package com.example.rexyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<NameBean> nameBeanList = new ArrayList<>();
    TitleAdapter adapter1;
    RecyclerViewAdapter adapter2;
    private int selectIndex=0;
    private RecyclerView recyclerView1,recyclerView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        recyclerView1 = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(layoutManager.HORIZONTAL);
        recyclerView1.setLayoutManager(layoutManager);


        adapter1 = new TitleAdapter(nameBeanList,selectIndex);
        recyclerView1.setAdapter(adapter1);


        recyclerView2=(RecyclerView)findViewById(R.id.recycler_view1);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(linearLayoutManager);
        adapter2=new RecyclerViewAdapter(Constant.strs2,selectIndex);
        recyclerView2.setAdapter(adapter2);
        initItemClickListener();
    }



    private void initFruits() {
        for (int i = 0; i < 5; i++) {
            NameBean banana = new NameBean(Constant.dataTitle[i]);
            nameBeanList.add(banana);
        }

    }
    private void initItemClickListener() {
        OnRecyclerItemClickListener itemClickListener = new OnRecyclerItemClickListener() {
            /**
             * item 点击事件
             *
             * @param position
             */
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();
                selectIndex=position;
                adapter1.setIndex(position);
                adapter1.notifyDataSetChanged();
                recyclerView1.smoothScrollToPosition(position);
                adapter2.setIndex(position);
                recyclerView2.setAdapter(adapter2);
                recyclerView2.smoothScrollToPosition(position);
            }


        };
        adapter1.setRecyclerItemClickListener(itemClickListener);
    }


}
