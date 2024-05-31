package com.is360.me_azkar;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;


import com.is360.me_azkar.data.model.FetchedModel;
import com.is360.me_azkar.data.model.UserModel;
import com.is360.me_azkar.ui.viewmodel.MainViewModel;
import com.is360.me_azkar.ui.viewmodel.MainViewModelFactor;

import java.util.ArrayList;
import java.util.List;

public class ShowSupplications extends AppCompatActivity {

    ArrayList<Model> arrayList;
    RecyclerView recyclerView;
//    DatabaseHelper databaseHelper;
    String data = MainActivity.getSupplication();

    private MainViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        viewModel = new ViewModelProvider(this , new MainViewModelFactor(getApplication())).get(MainViewModel.class);




        initToolbar();

        recyclerView = findViewById(R.id.recycler_view);
        viewModel.getSupplication();
        viewModel.getSupplication.observe(this, new Observer<List<FetchedModel>>() {
            @Override
            public void onChanged(List<FetchedModel> fetchedModels) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                Adapter adapter = new Adapter(getApplicationContext() , ShowSupplications.this , fetchedModels);
                recyclerView.setAdapter(adapter);

                for (FetchedModel model : fetchedModels){
                    Log.d("list" , model.getSupplication_id() +"----"+model.getSupplication_order());
                }

            }
        });
//        databaseHelper = new DatabaseHelper(this);
//        displayRow();
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(this, MainActivity.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(myIntent);
        finish();
        return true;
    }*/

    private void initToolbar() {
        try
        {
            //this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            if(data == "supplication_morning") {
                this.getSupportActionBar().setTitle("Morning Supplications");
            }
            else {
                this.getSupportActionBar().setTitle("Evening Supplications");
            }

            // this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            // WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        catch (NullPointerException e){}
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

//    private void displayRow() {
//        arrayList = new ArrayList<>(databaseHelper.getRowData());
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        Adapter adapter = new Adapter(getApplicationContext(), this, arrayList);
//        recyclerView.setAdapter(adapter);
//    }
}