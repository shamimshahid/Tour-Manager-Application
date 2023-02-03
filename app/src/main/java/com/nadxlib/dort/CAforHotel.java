package com.nadxlib.dort;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CAforHotel extends ArrayAdapter {
    private  int MY_PERMISSIONS_REQUEST_CALL_PHONE = 0;
    private Activity con;
    private List<PlaceInfo> students;



    public CAforHotel( Activity context,List<PlaceInfo> students) {
        super(context, R.layout.detailslayout, students);
        this.con = context;
        this.students = students;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = con.getLayoutInflater();

        View v = layoutInflater.inflate(R.layout.detailslayout, null, true);

        PlaceInfo student = students.get(position);
        TextView t1 =  v.findViewById(R.id.textView5);
        ImageView iv = v.findViewById(R.id.imageView);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),PlaceMapActivity.class);
                intent.putExtra("lat",student.latLng.latitude);
                intent.putExtra("name",student.getPlaceName());
                intent.putExtra("long",student.latLng.longitude);
                con.startActivity(intent);

            }
        });


        final String name = student.getPlaceName();
        iv.setImageResource(student.getPlacePic());
        t1.setText("Name: "+name);


        return v;
    }


}
