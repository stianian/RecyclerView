package com.example.rexyclerview;

import android.view.View;

public interface OnRecyclerItemClickListener {
    //RecyclerView的点击事件，将信息回调给view
    void onItemClick(View view, int position);
}