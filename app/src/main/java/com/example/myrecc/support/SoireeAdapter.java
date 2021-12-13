package com.example.myrecc.support;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrecc.DetailSoiree;
import com.example.myrecc.R;
import com.example.myrecc.metier.Soiree;

import java.util.ArrayList;
import java.util.List;

public class SoireeAdapter extends RecyclerView.Adapter<SoireeViewHolder> {
    List<Soiree> lesSoirees = new ArrayList<>();

    public SoireeAdapter(List<Soiree> lesSoirees) {
        this.lesSoirees = lesSoirees;
    }

    @NonNull
    @Override
    public SoireeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.soiree, parent, false);
        SoireeViewHolder soireeVH =  new SoireeViewHolder(v);
        return soireeVH;
    }

    @Override
    public void onBindViewHolder(@NonNull SoireeViewHolder holder, int position) {
        Soiree laSoiree = lesSoirees.get(position);
        holder.remplirHolder(laSoiree);
    }

    @Override
    public int getItemCount() {
        if(!lesSoirees.isEmpty()) return lesSoirees.size();
        else return 0;
    }
}
