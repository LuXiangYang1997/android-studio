package com.example.luxiangyang.memorandum_android.viewmodel;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.luxiangyang.memorandum_android.MyApplication;
import com.example.luxiangyang.memorandum_android.R;
import com.example.luxiangyang.memorandum_android.bean.DataBean;
import com.example.luxiangyang.memorandum_android.bean.DataBeanDao;
import com.example.luxiangyang.memorandum_android.constant.StatusVariable;
import com.example.luxiangyang.memorandum_android.view.EditDataActivity;

/**
 * Created by 陆向阳 on 2018/12/10 1:40 PM
 */
public class EditViewModel implements View.OnClickListener {

    private EditDataActivity editDataActivity;
    private EditText etContent;
    private String type;
    private DataBeanDao dataBeanDao;
    private EditText et_title;
    private Long id;
    private LinearLayout llDelete;

    public EditViewModel(EditDataActivity editDataActivity) {
        this.editDataActivity = editDataActivity;
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        //获取DataBean对象
        dataBeanDao = MyApplication.getInstance().getDaoSession().getDataBeanDao();

        LinearLayout llSave = editDataActivity.findViewById(R.id.ll_save);
        TextView tvStatus = editDataActivity.findViewById(R.id.tv_status);
        etContent = editDataActivity.findViewById(R.id.et_content);
        et_title = editDataActivity.findViewById(R.id.et_title);
        llDelete = editDataActivity.findViewById(R.id.ll_delete);
        llDelete.setOnClickListener(this);


        llSave.setOnClickListener(this);
        type = editDataActivity.getIntent().getStringExtra(StatusVariable.INTENTTYPE);
        //判断是保存还是修改
        if(type.equals(StatusVariable.NEWDATA)){
            tvStatus.setText(editDataActivity.getResources().getString(R.string.save));
        }else{
            tvStatus.setText(editDataActivity.getResources().getString(R.string.modify));
            llDelete.setVisibility(View.VISIBLE);
            id = editDataActivity.getIntent().getLongExtra(StatusVariable.ID,0);
            initData();
        }

    }

    /**
     * 查询数据
     */
    private void initData() {
        DataBean dataBean = dataBeanDao.queryBuilder().where(DataBeanDao.Properties._id.eq(id)).build().unique();
        et_title.setText(dataBean.getTitle());
        etContent.setText(dataBean.getContent());
    }

    /**
     * 保存数据
     */
    private void saveData() {

       DataBean dataBean = new DataBean();
       dataBean.setContent(etContent.getText().toString());
       dataBean.setTitle(et_title.getText().toString());
       dataBeanDao.insert(dataBean);

       Toast.makeText(editDataActivity,"保存成功",Toast.LENGTH_SHORT).show();
       editDataActivity.finish();
    }

    /**
     * 修改数据
     */
    private void modifyData(){

        if (id != null){
            DataBean dataBean = dataBeanDao.queryBuilder().where(DataBeanDao.Properties._id.eq(id)).build().unique();
            dataBean.setContent(etContent.getText().toString());
            dataBean.setTitle(et_title.getText().toString());
            dataBeanDao.update(dataBean);
        }
        Toast.makeText(editDataActivity,"修改成功",Toast.LENGTH_SHORT).show();
        editDataActivity.finish();
    }

    /**
     * 删除
     */
    private void delete() {

        if (id != null){
            DataBean dataBean = dataBeanDao.queryBuilder().where(DataBeanDao.Properties._id.eq(id)).build().unique();
            dataBeanDao.delete(dataBean);
        }
        Toast.makeText(editDataActivity,"删除成功",Toast.LENGTH_SHORT).show();
        editDataActivity.finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_save:
                if (TextUtils.isEmpty(et_title.getText().toString())&&TextUtils.isEmpty(etContent.getText().toString())){
                    Toast.makeText(editDataActivity,"标题或内容不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(type.equals(StatusVariable.NEWDATA)){
                    saveData();
                }else{
                    modifyData();
                }
                break;
                case R.id.ll_delete:
                    delete();
                    break;
        }
    }




}
