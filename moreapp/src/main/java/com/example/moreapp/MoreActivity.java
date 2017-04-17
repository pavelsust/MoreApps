package com.example.moreapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MoreActivity extends AppCompatActivity implements MoreAppAdapter.CallBcack{


    private static final String TAG_NAME = MoreActivity.class.getSimpleName();
    RecyclerView recyclerView;
    MoreAppAdapter adapter;
    public ArrayList<Items> itemsArrayList;


    public static String url;
    //= "http://banglahdnatok.com/more_app.txt";
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_more);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("More Apps");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        itemsArrayList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MoreAppAdapter(getApplicationContext() , itemsArrayList , this);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        recyclerView.setAdapter(adapter);

        JsonArrayRequest movieReq = new JsonArrayRequest( url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG_NAME, response.toString());



                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Items song = new Items();
                                song.setName(obj.getString("name"));
                                song.setImageId(obj.getString("image"));
                                song.setId(obj.getLong("rating"));
                                song.setLink(obj.getString("package_name"));
                                itemsArrayList.add(song);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data

                        adapter.notifyDataSetChanged();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG_NAME, "Error: " + error.getMessage());


            }
        });


        movieReq.setShouldCache(false);

        // Adding request to request queue
        App.getInstance().addToRequestQueue(movieReq);
    }


    @Override
    public void show(int position, Items items) {
        String hollywood_movie_link = items.getLink();
        Intent intent2 = new Intent(Intent.ACTION_VIEW,
                Uri.parse("market://details?id="
                        + hollywood_movie_link));
        intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent2);
    }
}
