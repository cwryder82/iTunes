package com.mac.chris.itunes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mac.chris.itunes.retrofit.RetrofitHelper;
import com.mac.chris.itunes.pojos.Result;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etQuery;
    Button btn;
    RecyclerView recyclerView;
    RVAdapter adapter;
    StaggeredGridLayoutManager sglm;
    List<Result> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etQuery = (EditText) findViewById(R.id.searchText);
        btn = (Button) findViewById(R.id.button);

        recyclerView = (RecyclerView) findViewById(R.id.rv);

        recyclerView.setHasFixedSize(true);
        sglm = new StaggeredGridLayoutManager(2,1);
        recyclerView.setLayoutManager(sglm);
    }

    public void doStuff (View v) {
        RetrofitHelper rfh = new RetrofitHelper(etQuery.getText().toString());
        try {
            results = rfh.execute().get();
        }
        catch (Exception e) {
            System.out.println("Some Exception");
        }

        adapter = new RVAdapter(this, results);
        recyclerView.setAdapter(adapter);
    }

}