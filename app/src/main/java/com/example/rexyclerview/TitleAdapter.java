package com.example.rexyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.ViewHolder> {
    private int selectIndex;
    private List<NameBean> mNameBeanList;
    //声明自定义的监听接口
    private OnRecyclerItemClickListener monItemClickListener;

    //提供set方法供Activity或Fragment调用
    public void setRecyclerItemClickListener(OnRecyclerItemClickListener listener){
        monItemClickListener=listener;
    }




     class ViewHolder extends RecyclerView.ViewHolder {
        TextView fruitName;
        public ViewHolder(View view) {
            super(view);

            fruitName = (TextView) view.findViewById(R.id.fruitname);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (monItemClickListener!=null){
                        monItemClickListener.onItemClick(view,getAdapterPosition());
                    }
                }
            });

        }

    }

    public TitleAdapter(List<NameBean> nameBeanList, int selectIndex) {
        mNameBeanList = nameBeanList;
        this.selectIndex=selectIndex;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NameBean nameBean = mNameBeanList.get(position);
        holder.fruitName.setText(nameBean.getName());
    }

    @Override
    public int getItemCount() {
        return mNameBeanList.size();
    }
    public void setIndex(int index){
        selectIndex = index;
    }
}
