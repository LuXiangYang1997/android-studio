package com.example.luxiangyang.memorandum_android.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.luxiangyang.memorandum_android.R;
import com.example.luxiangyang.memorandum_android.bean.DataBean;

/**
 * Created by 陆向阳 on 2018/12/10 12:45 PM
 */
public class ListDataAdapter extends BaseAdapter<DataBean,ListDataAdapter.ListDataViewHolder>{

    private Context context;

    public ListDataAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public ListDataViewHolder onCreateVH(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent,false);

        return new ListDataViewHolder(view);
    }

    @Override
    public void onBindVH(ListDataViewHolder listDataViewHolder, final int position) {
        if (!TextUtils.isEmpty(mList.get(position).getTitle())){
            listDataViewHolder.tvTitle.setText(mList.get(position).getTitle());
        }
        if (!TextUtils.isEmpty(mList.get(position).getContent())){
            listDataViewHolder.tvContent.setText(mList.get(position).getContent());
        }
        //标记
        if (mList.get(position).getImportance()){
            listDataViewHolder.tvTop.setText("取消标记");
            listDataViewHolder.tv_status.setText("(重要)");
            listDataViewHolder.tv_status.setTextColor(Color.RED);
        }else{
            listDataViewHolder.tv_status.setText("(普通)");
            listDataViewHolder.tvTop.setText("标记");
            listDataViewHolder.tv_status.setTextColor(Color.GRAY);
        }

        listDataViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick.itemClick(position,mList.get(position).get_id());
            }
        });
        //置顶点击事件
        listDataViewHolder.tvTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topClick.topClcik(position,mList.get(position).get_id());
            }
        });


    }

    class ListDataViewHolder extends RecyclerView.ViewHolder{


        private final TextView tvTitle;
        private final TextView tvContent;
        private final TextView tvTop;
        private final TextView tv_status;

        public ListDataViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvTop = itemView.findViewById(R.id.tv_top);
            tv_status = itemView.findViewById(R.id.tv_status);
        }

    }

    public interface ItemClick{

        void itemClick(int position,Long id);

    }

    ItemClick itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public interface TopClick{

        void topClcik(int position,Long id);

    }

    TopClick topClick;

    public void setTopClick(TopClick topClick) {
        this.topClick = topClick;
    }
}
