package com.example.jefferson.theme.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jefferson.theme.R;
import com.example.jefferson.theme.model.Animal;
import com.example.jefferson.theme.model.Landscape;

import java.util.List;

/**
 * Created by jefferson on 16/10/17.
 */

public class RecyclerAdapterAnimal extends RecyclerView.Adapter<RecyclerAdapterAnimal.MyViewHolder> {

    private List<Animal> mData;
    private LayoutInflater layoutInflater;


    public RecyclerAdapterAnimal(Context context, List<Animal> data) {
        this.layoutInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Animal currentObj = mData.get(position);
        holder.setData(currentObj, position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private int position;
        private ImageView imgThumb;
        private Animal current;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.textViewTitle);
            imgThumb = (ImageView) view.findViewById(R.id.img_row);
        }

        public void setData(Animal currentObj, int position) {
            this.title.setText(currentObj.getTitle());
            this.imgThumb.setImageResource(currentObj.getImageId());
            this.position = position;
            this.current = currentObj;

        }
    }
}

