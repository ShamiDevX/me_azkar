package com.is360.me_azkar.ui.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.is360.me_azkar.data.model.FetchedModel;
import com.is360.me_azkar.data.model.UserModel;
import com.is360.me_azkar.data.repo.Repo;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainViewModel extends ViewModel {


    private final Repo repo;
    private MutableLiveData<List<FetchedModel>> supplicationData;
    public   LiveData<List<FetchedModel>> getSupplication ;
    private  ExecutorService executorService;


    public MainViewModel(Application application)  {
        repo = new Repo(application);
        supplicationData = new MutableLiveData<>();
        executorService = Executors.newSingleThreadExecutor();
        getSupplication = supplicationData;
//        getSupplication. = repo.getSupplication();

    }


    public void  getSupplication (){
        executorService.execute(() -> {
            supplicationData.postValue(repo.getSupplication());
        });
    }



}
