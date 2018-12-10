package com.example.luxiangyang.memorandum_android.viewmodel;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.luxiangyang.memorandum_android.MainActivity;
import com.example.luxiangyang.memorandum_android.MyApplication;
import com.example.luxiangyang.memorandum_android.R;
import com.example.luxiangyang.memorandum_android.adapter.ListDataAdapter;
import com.example.luxiangyang.memorandum_android.bean.DataBean;
import com.example.luxiangyang.memorandum_android.bean.DataBeanDao;
import com.example.luxiangyang.memorandum_android.constant.StatusVariable;
import com.example.luxiangyang.memorandum_android.view.EditDataActivity;

import java.util.List;

/**
 * Created by 陆向阳 on 2018/12/10 12:44 PM
 */
public class DataViewModel implements View.OnClickListener {

    private MainActivity mainActivity;
    private ListDataAdapter listDataAdapter;
    private ImageView imgAdd;
    private RecyclerView rvList;
    private DataBeanDao dataBeanDao;
    private List<DataBean> dataBeanList;

    public DataViewModel(MainActivity mainActivity, ListDataAdapter listDataAdapter) {
        this.mainActivity = mainActivity;
        this.listDataAdapter = listDataAdapter;
        init();
        initData();
        initClick();
    }

    /**
     * 点击事件
     */
    private void initClick() {

        listDataAdapter.setItemClick(new ListDataAdapter.ItemClick() {
            @Override
            public void itemClick(int position, Long id) {
                Intent intent = new Intent(mainActivity, EditDataActivity.class);
                intent.putExtra(StatusVariable.INTENTTYPE,StatusVariable.MODIFYDATA);
                intent.putExtra(StatusVariable.ID,id);
                mainActivity.startActivity(intent);
            }
        });


        listDataAdapter.setTopClick(new ListDataAdapter.TopClick() {
            @Override
            public void topClcik(int position, Long id) {
                if (id != null) {
                    DataBean dataBean = dataBeanDao.queryBuilder().where(DataBeanDao.Properties._id.eq(id)).build().unique();
                    if (dataBean.getImportance()){
                        dataBean.setImportance(false);
                    }else{
                        dataBean.setImportance(true);
                    }
                    dataBeanDao.update(dataBean);
                    initData();
                }
            }
        });
    }

    /**
     * 初始化
     */
    private void init() {

        dataBeanDao = MyApplication.getInstance().getDaoSession().getDataBeanDao();

        rvList = mainActivity.findViewById(R.id.rv_list);
        imgAdd = mainActivity.findViewById(R.id.img_add);

        imgAdd.setOnClickListener(this);

        rvList.setLayoutManager(new LinearLayoutManager(mainActivity));
        rvList.setAdapter(listDataAdapter);

    }

    /**
     * 初始化数据
     */
    public void initData() {

        //查出所有数据
        dataBeanList = dataBeanDao.loadAll();
        listDataAdapter.loadData(dataBeanList);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_add:
                Intent intent = new Intent(mainActivity, EditDataActivity.class);
                intent.putExtra(StatusVariable.INTENTTYPE,StatusVariable.NEWDATA);
                mainActivity.startActivity(intent);
                break;
        }
    }
}
