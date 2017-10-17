package com.example.jefferson.theme.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jefferson.theme.R;
import com.example.jefferson.theme.model.Landscape;

import java.util.List;

/**
 * Created by jefferson on 16/10/17.
 */

public class RecyclerAdapterLandscape extends RecyclerView.Adapter<RecyclerAdapterLandscape.MyViewHolder> {

    private List<Landscape> mData;
    private LayoutInflater layoutInflater;


    public RecyclerAdapterLandscape(Context context, List<Landscape> data) {
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
        Landscape currentObj = mData.get(position);
        holder.setData(currentObj, position);
        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void removeItem(int position){
        mData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mData.size());

    }

    public void addItem(int position, Landscape landscape){
        mData.add(position, landscape);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, mData.size());
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView title;
        private int position;
        private ImageView imgThumb, imgDelete, imgAdd;
        private Landscape current;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.textViewTitle);
            imgThumb = (ImageView) view.findViewById(R.id.img_row);
            imgDelete = (ImageView) view.findViewById(R.id.img_row_delete);
            imgAdd = (ImageView) view.findViewById(R.id.img_row_add);
        }

        public void setData(Landscape currentObj, int position) {
            this.title.setText(currentObj.getTitle());
            this.imgThumb.setImageResource(currentObj.getImageId());
            this.position = position;
            this.current = currentObj;
        }

        public void setListeners(){
            imgDelete.setOnClickListener(MyViewHolder.this);
            imgAdd.setOnClickListener(MyViewHolder.this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.img_row_delete:
                    removeItem(position);
                    break;
                case R.id.img_row_add:
                    addItem(position, current);
                    break;
            }
        }
    }
}

