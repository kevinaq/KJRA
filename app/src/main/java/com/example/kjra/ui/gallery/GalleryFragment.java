package com.example.kjra.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kjra.R;
import com.example.kjra.adapter.BibliaAdapter;
import com.example.kjra.api.RetrofitService;
import com.example.kjra.api.Service;
import com.example.kjra.databinding.FragmentGalleryBinding;
import com.example.kjra.model.Biblia;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryFragment extends Fragment {


    RecyclerView recycler_view;
    BibliaAdapter adapter;
    List<Biblia> bibliaList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle Savedstatecinstantece) {
        View view = inflater.inflate(R.layout.fragment_gallery, parent, false);
        recycler_view = view.findViewById(R.id.recycler_view);

        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));


        Service service = RetrofitService.getRetrofit().create(Service.class);
        Call<List<Biblia>> call = service.getListBiblia();
        call.enqueue(new Callback<List<Biblia>>() {
            @Override
            public void onResponse(Call<List<Biblia>> call, Response<List<Biblia>> response) {
                if (response.isSuccessful()) {

                    adapter = new BibliaAdapter((ArrayList<Biblia>) response.body());
                    recycler_view.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Biblia>> call, Throwable t) {

                Toast.makeText(getContext(), "Error al conectar con el servicio", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }


}