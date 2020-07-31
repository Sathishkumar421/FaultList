package com.example.controlapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.controlapp.adapter.RecyclerVIewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private RequestQueue queue;
    private RecyclerView recyclerView;
    private RecyclerVIewAdapter recyclerVIewAdapter;
    private ArrayList<Single_Fault> FaultList= new ArrayList<Single_Fault>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String url="https://jsonplaceholder.typicode.com/todos";
        queue= Volley.newRequestQueue(MainActivity.this);
        recyclerView= findViewById(R.id.recycler_view);
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response)
                    {
                        try
                        {
                                for (int i = 0; i < response.length(); i++)
                                {
                                    JSONObject jsonObject = response.getJSONObject(i);
                                    String id= String.valueOf(jsonObject.getInt("id"));
                                    String taskStatus = String.valueOf(jsonObject.getBoolean("completed"));
                                    String title= jsonObject.getString("title");
                                    String place= "Acropolis Block B";
                                    String days= String.valueOf(jsonObject.getString("userId"))+ "days ago";
                                    String Type1= "Electrical";
                                    String Type2= "High";
                                    String Type3= "WebWorkOrder";
                                    FaultList.add(new Single_Fault(id,taskStatus,title,place,days,Type1,Type2,Type3));
                                }
                                recyclerVIewAdapter = new RecyclerVIewAdapter(MainActivity.this,FaultList);
                                recyclerView.setAdapter(recyclerVIewAdapter);
                                recyclerView.setHasFixedSize(true);
                                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        }
                            catch (JSONException e) {
                                e.printStackTrace();
                            }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
        queue.add(jsonArrayRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle presses on the action bar items
        switch (item.getItemId())
        {
            case R.id.search:
                Toast.makeText(
                        getApplicationContext(),
                        "You clicked the search button.",
                        Toast.LENGTH_SHORT)
                        .show();
                return true;
            case R.id.action_settings:
                Toast.makeText(
                        getApplicationContext(),
                        "You clicked the settings button.",
                        Toast.LENGTH_SHORT)
                        .show();
                return true;
            case R.id.action_login:
                Toast.makeText(
                        getApplicationContext(),
                        "Login",
                        Toast.LENGTH_SHORT)
                        .show();
                return true;
            case R.id.action_logout:
                Toast.makeText(
                        getApplicationContext(),
                        "Logout",
                        Toast.LENGTH_SHORT)
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}