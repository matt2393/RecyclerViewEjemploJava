package com.matt2393.recyclerviewejemplojava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EjemploAdapter adapter;
    private Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new EjemploAdapter(new ArrayList<Otro>(),this);
        recyclerView.setAdapter(adapter);

        gson = new Gson();
        api();

    }

    private void api(){
        String url="https://sistematallermecanico.com/api/api.php?otro&idcliente=20";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        ArrayList<Otro> otros=new ArrayList<>();
                        for(int i=0;i<response.length();i++){
                            try {
                                JSONObject json =response.getJSONObject(i);
                                JSONArray jArray = json.getJSONArray("datos");
                                ArrayList<Datos> datos = new ArrayList<>();
                                for(int j = 0;j<jArray.length();j++){
                                    JSONObject obj = jArray.getJSONObject(j);
                                    Datos dd = gson.fromJson(obj.toString(), Datos.class);
                                    datos.add(dd);
                                }
                                Otro ot=new Otro();
                                ot.setFecha(json.getString("fecha"));
                                ot.setDatos(datos);
                                otros.add(ot);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter.setOtros(otros);
                        adapter.notifyDataSetChanged();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Error: "+error.toString(),Toast.LENGTH_LONG).show();
                    }
                });

        VolleyQueue.getInstance(this).addColaRequest(jsonArrayRequest);
    }
}
