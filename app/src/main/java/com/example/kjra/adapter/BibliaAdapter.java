package com.example.kjra.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.kjra.ImageRequester;
import com.example.kjra.R;
import com.example.kjra.model.Biblia;

import java.util.ArrayList;

public class BibliaAdapter extends RecyclerView.Adapter<BibliaAdapter.ViewHolder>{

    private ArrayList<Biblia> bibliaList;

    ImageRequester imageRequester;

    public BibliaAdapter(ArrayList<Biblia> bibliaList) {
        imageRequester = ImageRequester.getInstance();
        this.bibliaList = bibliaList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from( viewGroup.getContext()).inflate(R.layout.golden_card, viewGroup,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Biblia biblia = bibliaList.get(position);
        holder.nameTextView.setText(biblia.getNombre());
        imageRequester.setImageFromUrl(holder.bibliaImageView, biblia.getImage());


    }

    @Override
    public int getItemCount()  {

        return bibliaList.size();
    }
    public  class ViewHolder extends RecyclerView.ViewHolder{
        NetworkImageView bibliaImageView;
        TextView nameTextView;

        public ViewHolder(View itemView){
            super(itemView);
            bibliaImageView=itemView.findViewById(R.id.bibliaImageView);
            nameTextView=itemView.findViewById(R.id.nameTextView);

        }
    }

}
