package com.nadxlib.dort;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import java.io.Serializable;
import java.util.List;

public class CA extends ArrayAdapter  {
    private  int MY_PERMISSIONS_REQUEST_CALL_PHONE = 0;
    private Activity con;
    private List<PlaceInfo> students;



    public CA( Activity context,List<PlaceInfo> students) {
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
        t1.setText(name);


        return v;
    }


}

