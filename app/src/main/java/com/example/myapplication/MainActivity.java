package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Country> countris=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countris.add(new Country("Brasil","Brasilia",10000,R.drawable.brazil));
//        countris.add(new Country("Urugway","Brasilia",10000,R.drawable.brazil));
//        countris.add(new Country("Germany","Brasilia",10000,R.drawable.brazil));
//        countris.add(new Country("France","Brasilia",10000,R.drawable.brazil));
//        countris.add(new Country("Brasil","Brasilia",10000,R.drawable.brazil));
//        countris.add(new Country("Brasil","Brasilia",10000,R.drawable.brazil));
//        countris.add(new Country("Brasil","Brasilia",10000,R.drawable.brazil));
//        countris.add(new Country("Brasil","Brasilia",10000,R.drawable.brazil));
        RecyclerView rv=findViewById(R.id.rv);
        CountryAdapter.OnStateClickListener stateClickListener=new CountryAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(Country country, int position) {
                Toast.makeText(getApplicationContext(),country.getName(),Toast.LENGTH_SHORT).show();
            }
        };
        CountryAdapter adapter=new CountryAdapter(countris,this,stateClickListener);
        rv.setAdapter(adapter);
    }
}