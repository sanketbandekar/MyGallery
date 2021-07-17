package com.example.mygallery.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mygallery.Adapter.GridAdaptor;
import com.example.mygallery.Interface.Api;
import com.example.mygallery.Modal.Main;
import com.example.mygallery.Modal.Photo;
import com.example.mygallery.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment {

    final String BASE_URL = "https://api.flickr.com/services/rest/";
    RecyclerView recyclerView;
    private List<Photo> photos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView = view.findViewById(R.id.recycler_view);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        Api api = retrofit.create(Api.class);

        Call<Main> call = api.getImages();

        call.enqueue(new Callback<Main>() {
            @Override
            public void onResponse(Call<Main> call, Response<Main> response) {

                photos = response.body().getPhotos().getPhoto();

                recyclerView.setAdapter(new GridAdaptor(getActivity(),photos));
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

            }

            @Override
            public void onFailure(Call<Main> call, Throwable t) {
                Toast.makeText(getActivity(), "error: "+t, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}