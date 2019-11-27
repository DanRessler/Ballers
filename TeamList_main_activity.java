//Source: From CMSC434 Peng lecture 11/26
package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.BaseBundle;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {


    int [] images = {R.drawable.team1, R.drawable.team2, R.drawable.team3,
                            R.drawable.team4,R.drawable.team5,R.drawable.team6,R.drawable.team7
            ,R.drawable.team7,R.drawable.team7,R.drawable.team7,R.drawable.team7};

    String [] titles = {"Team1", "Team2", "Team3", "Team4", "Team5", "Team6", "Team7"
            , "Team7", "Team7", "Team7", "Team7"};

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);
        CustomAdapter adapter = new CustomAdapter();
        listview.setAdapter(adapter);

    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount(){
            return images.length;
        }

        @Override
        public Object getItem(int position){
            return null;
        }

        @Override
        public long getItemId(int position){
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            //take customized layout file and create a view based on that
            View view = getLayoutInflater().inflate(R.layout.listview_item, null);
            ImageView imgview = view.findViewById(R.id.image_icon);
            TextView txtview = view.findViewById(R.id.title);
            imgview.setImageResource(images[position]);
            txtview.setText(titles[position]);

            return view;
        }
    }
}