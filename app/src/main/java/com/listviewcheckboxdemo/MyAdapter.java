package com.listviewcheckboxdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanyuan on 2017/11/16.
 */

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private List<Person> mDatas = new ArrayList();

    public MyAdapter(Context context) {
        mContext = context;
    }

    public void setDatas(List datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Person getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        //int index = position;
        final ViewHolder mViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_checkbox, parent, false);
            mViewHolder = new ViewHolder(convertView);
            convertView.setTag(mViewHolder);

        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
//        mViewHolder.mCbCheckbox.setTag(mDatas.get(position));
//        mViewHolder.mCbCheckbox.setOnCheckedChangeListener(this);
//        mViewHolder.mCbCheckbox.setChecked(mDatas.get(position).getCheckStatus());
//        mDatas.get(position).setCheckStatus(mDatas.get(position).getCheckStatus()?true:false);


        if (mDatas.get(position).isChecked()) {
            mViewHolder.mCbCheckbox.setChecked(true);
        } else {
            mViewHolder.mCbCheckbox.setChecked(false);
        }

        mViewHolder.mTvTitle.setText(mDatas.get(position).getTitle());
        return convertView;
    }

//    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        Person person = (Person) buttonView.getTag();
//        person.setCheckStatus(isChecked);
//    }

    static class ViewHolder {
        TextView mTvTitle;
        CheckBox mCbCheckbox;

        ViewHolder(View view) {
            mTvTitle = (TextView) view.findViewById(R.id.tv_title);
            mCbCheckbox = (CheckBox) view.findViewById(R.id.cb_checkbox);
        }
    }
}
