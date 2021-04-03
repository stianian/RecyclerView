package com.example.rexyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder>{

    private int selection;
    Context context;
    public RecyclerViewAdapter2(Context context,int selection){
        this.context=context;
        this.selection=selection;
    }





    @NonNull
    @Override
    public RecyclerViewAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_concrete,parent,false);
        ViewHolder holder =new ViewHolder(view);
        return holder;


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter2.ViewHolder holder, int position) {
        holder.tvName1.setText(Constant.strs2[selection][position]);
        holder.imageView.setImageResource(Constant.drink[selection][position]);
    }

    @Override
    public int getItemCount() {
        return Constant.strs2[0].length;
    }




    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName1;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName1=(TextView)itemView.findViewById(R.id.name1);
            imageView=(ImageView)itemView.findViewById(R.id.iv_drink);
        }
    }


}
