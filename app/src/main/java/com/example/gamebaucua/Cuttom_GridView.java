package com.example.gamebaucua;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class Cuttom_GridView extends ArrayAdapter<Integer> {
    Context context;
    int resource;
    Integer[] objects;
    Integer[] giaTien = {0,100,200,300,400,500};
    ArrayAdapter<Integer> adapter;
    public  Cuttom_GridView (Context context, int resource, Integer[] objects){
        super(context,resource,objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
        adapter = new ArrayAdapter<Integer>(context, android.R.layout.simple_spinner_item, giaTien);
    }

    public View getView(final int position, View convertView, ViewGroup parent){
        View view = View.inflate(context,resource,null);
        ImageView imgBanCo = (ImageView)view.findViewById(R.id.imgBanCo);
        Spinner spinGia = view.findViewById(R.id.spinGia);
        imgBanCo.setImageResource(objects[position]);
        spinGia.setAdapter(adapter);

        spinGia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int positionspin, long id) {
                MainActivity.gtDatCuoc[position] = giaTien[positionspin];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }
}
