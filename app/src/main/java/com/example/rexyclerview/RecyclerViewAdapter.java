package com.example.rexyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private  String[][] allData;
    private int selection;

    Context context;
    public RecyclerViewAdapter(String[][] strings,int selection){
        this.allData=strings;
        this.selection=selection;
    }



    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sort,parent,false);
        ViewHolder holder =new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        RecyclerViewAdapter2 adapter3=new RecyclerViewAdapter2(context,position);
        holder.recyclerView.setAdapter(adapter3);
    }

    @Override
    public int getItemCount() {
        return allData[0].length;
    }




    class ViewHolder extends RecyclerView.ViewHolder{


        private RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            recyclerView=(RecyclerView)itemView.findViewById(R.id.list1);
            GridLayoutManager linearLayoutManager=new GridLayoutManager(context,3);
            linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);

        }








    }

    public void setIndex(int index){
        selection=index;
    }

}
