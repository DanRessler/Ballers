package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.SearchView;
import java.util.ArrayList;

public class AddPlayersToTeam extends AppCompatActivity {

    int [] images = {R.drawable.team1, R.drawable.team2, R.drawable.team3,
            R.drawable.team4,R.drawable.team5};
    int [] images2 = {R.drawable.team6, R.drawable.team2, R.drawable.team7,
            R.drawable.team3,R.drawable.team4};

    String [] titles = {"Player1", "Player2", "Player3", "Player4", "Player5"};

    String [] titles2 = {"BallerDude4", "BallerMan5", "BuddyBoy6", "Username3", "Username4"};



    ListView listview;
    ListView listview2;

    //use for the search results list
    ArrayList<String> query1 = new ArrayList<String>();


    Button button;
    SearchView s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players_to_team);

        listview = findViewById(R.id.playerlistview);
        AddPlayersToTeam.CustomAdapter adapter = new AddPlayersToTeam.CustomAdapter();
        listview.setAdapter(adapter);

        listview2 = findViewById(R.id.playerlistviewUser);
        AddPlayersToTeam.CustomAdapter2 adapter2 = new AddPlayersToTeam.CustomAdapter2();
        listview2.setAdapter(adapter2);

        button = findViewById(R.id.BackButton);
        button.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick (View v){
                next_page1(v);
            }
        });

        SearchView search = findViewById(R.id.searchView);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                query1 = filt(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                query1 = filt(newText);
                return false;
            }
        });


    }

    public void next_page1(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public ArrayList<String> filt(String input){
        ArrayList<String> ret = new ArrayList<String>();
        for (int x = 0; x < titles2.length; x++){
            boolean flag = true;
            for (int i = 0; i < input.length(); i++){
                if (input.charAt(i) != titles2[x].charAt(i)){
                    flag = false;
                }
            }
            if (flag){
                ret.add(titles2[x]);
            }
        }

        System.out.print(ret);
        return ret;

    }

    class CustomAdapter extends BaseAdapter {

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
            View view = getLayoutInflater().inflate(R.layout.listview_player, null);
            //ImageView imgview = view.findViewById(R.id.image_icon);
            TextView txtview = view.findViewById(R.id.title);
            //imgview.setImageResource(images[position]);
            txtview.setText(titles[position]);
            final Button button3 = view.findViewById(R.id.AddPlayers);
            button3.setOnClickListener( new View.OnClickListener(){
                @Override
                public void onClick (View v){
                    button3.setText("Request Sent!");
                    button3.setBackgroundColor(Color.GREEN);
                }
            });

            return view;
        }
    }

    class CustomAdapter2 extends BaseAdapter {

        @Override
        public int getCount(){
            return query1.size();
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
            View view = getLayoutInflater().inflate(R.layout.listview_player, null);
            ImageView imgview = view.findViewById(R.id.image_icon);
            TextView txtview = view.findViewById(R.id.title);
            imgview.setImageResource(images2[position]);
            txtview.setText(query1.get(position));
            final Button button3 = view.findViewById(R.id.AddPlayers);
            button3.setOnClickListener( new View.OnClickListener(){
                @Override
                public void onClick (View v){
                    button3.setText("Request Sent!");
                    button3.setBackgroundColor(Color.GREEN);
                }
            });

            return view;
        }
    }
}