package com.joaquinalan.petagram;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by joaquinalan on 29/01/2017.
 */

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {
    private ArrayList<Pet> mPetList;
    private Activity mActivity;

    public PetAdapter(ArrayList<Pet> petList, Activity activity) {
        this.mPetList = petList;
        this.mActivity = activity;
    }

    // It inflates layout and passes viewHolder to get the views
    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet, parent, false);
        return new PetViewHolder(view);
    }

    // Matches each element from the list each view
    @Override
    public void onBindViewHolder(final PetViewHolder holder, int position) {
        final Pet pet = mPetList.get(position);

        holder.imgPetImage.setImageResource(pet.getImage());
        holder.tvName.setText(pet.getName());
        holder.tvRating.setText(String.valueOf(pet.getRating()));

        holder.btnLikeBone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, mActivity.getString(R.string.cardview_like_snackbar_message) +
                        " " + pet.getName(), Snackbar.LENGTH_SHORT).show();
                pet.likePet();
                holder.tvRating.setText(String.valueOf(pet.getRating()));
            }
        });
    }

    @Override
    public int getItemCount() { // Number of elements that my List has.
        return mPetList.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPetImage;
        private ImageButton btnLikeBone;
        private TextView tvName;
        private TextView tvRating;

        public PetViewHolder(View itemView) {
            super(itemView);
            imgPetImage = (ImageView) itemView.findViewById(R.id.img_pet_image);
            btnLikeBone = (ImageButton) itemView.findViewById(R.id.btn_like_bone);
            tvName = (TextView) itemView.findViewById(R.id.tv_cardview_pet_name);
            tvRating = (TextView) itemView.findViewById(R.id.tv_cardview_rating);
        }
    }
}
