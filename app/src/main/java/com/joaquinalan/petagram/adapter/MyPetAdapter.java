package com.joaquinalan.petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.joaquinalan.petagram.R;
import com.joaquinalan.petagram.pojo.MyPetImage;

import java.util.ArrayList;

/**
 * Created by joaquinalan on 01/02/2017.
 */

public class MyPetAdapter extends RecyclerView.Adapter<MyPetAdapter.MyPetViewHolder> {
    private ArrayList<MyPetImage> mMyPetImageList;
    private Activity mActivity;

    public MyPetAdapter(ArrayList<MyPetImage> myPetImageList, Activity activity) {
        this.mMyPetImageList = myPetImageList;
        this.mActivity = activity;
    }

    @Override
    public MyPetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_mypetadapter_mypetcardview, parent, false);
        return new MyPetAdapter.MyPetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyPetViewHolder holder, int position) {
        final MyPetImage petImage = mMyPetImageList.get(position);

        holder.mImageViewPetImage.setImageResource(petImage.getImage());
        holder.mTextViewRating.setText(String.valueOf(petImage.getRating()));
    }

    @Override
    public int getItemCount() {
        return mMyPetImageList.size();
    }

    public static class MyPetViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageViewPetImage;
        private TextView mTextViewRating;

        public MyPetViewHolder(View itemView) {
            super(itemView);
            mImageViewPetImage = (ImageView) itemView.findViewById(R.id.imageview_mypetcardview_petimage);
            mTextViewRating = (TextView) itemView.findViewById(R.id.textview_mypetcardview_rating);
        }
    }
}
