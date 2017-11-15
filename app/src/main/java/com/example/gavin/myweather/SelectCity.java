package com.example.gavin.myweather;
import android.app.Activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.pku.gavin.app.MyApplication;
import cn.edu.pku.gavin.bean.City;

/**
 * Created by GAVIN on 2017/10/18.
 */

public class SelectCity  extends Activity implements View.OnClickListener{
    private ImageView mBackBtn;
    private ListView cityListList;
    private List<City> mCityList;
    private MyApplication myApplication;
    private ArrayList<String> mArrayList;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_city);
        mBackBtn = (ImageView) findViewById(R.id.title_back);
        mBackBtn.setOnClickListener(this);

        myApplication=(MyApplication)getApplication();
        mCityList=myApplication.getCityList();
        mArrayList=new ArrayList<String>();
        for(int i=0;i<mCityList.size();i++)
        {
            String cityName =mCityList.get(i).getCity();
            mArrayList.add(cityName);
        }
        cityListList=(ListView)findViewById(R.id.selectcity_list);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(SelectCity.this,android.R.layout.simple_list_item_1,mArrayList);

        cityListList.setAdapter(adapter);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.title_back:
                Intent i = new Intent();
                i.putExtra("cityCode", "101160101");
                setResult(RESULT_OK, i);
                finish();
                break;
            default:
                break;
        }
    }
}