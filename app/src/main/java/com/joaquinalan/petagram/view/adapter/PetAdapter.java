package com.joaquinalan.petagram.view.adapter;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.joaquinalan.petagram.R;
import com.joaquinalan.petagram.model.domain.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaquinalan on 29/01/2017.
 */

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {
    private List<Pet> mPetList = new ArrayList<>();
    private Activity mActivity;

    public PetAdapter(Iterable<Pet> pets, Activity activity) {
        for (Pet pet : pets) {
            mPetList.add(pet);
        }
        this.mActivity = activity;
    }

    // It inflates layout and passes viewHolder to get the views
    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_petadapter_petcardview, parent, false);
        return new PetViewHolder(view);
    }

    // Matches each element from the list each view
    @Override
    public void onBindViewHolder(final PetViewHolder holder, int position) {
        final Pet pet = mPetList.get(position);

        holder.mImageViewPetImage.setImageResource(pet.getImage());
        holder.mTextViewName.setText(pet.getName());
        holder.mTextViewRating.setText(String.valueOf(pet.getRating()));

        holder.mButtonLikeBone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, mActivity.getString(R.string.petadapter_likesnackbarmessage) +
                        " " + pet.getName(), Snackbar.LENGTH_SHORT).show();
                pet.likePet();
                holder.mTextViewRating.setText(String.valueOf(pet.getRating()));
            }
        });
    }

    @Override
    public int getItemCount() { // Number of elements that my List has.
        return mPetList.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mImageViewPetImage;
        private final ImageButton mButtonLikeBone;
        private final TextView mTextViewName;
        private final TextView mTextViewRating;

        public PetViewHolder(View itemView) {
            super(itemView);
            mImageViewPetImage = (ImageView) itemView.findViewById(R.id.imageview_petcardview_petimage);
            mButtonLikeBone = (ImageButton) itemView.findViewById(R.id.button_petcardview_likebone);
            mTextViewName = (TextView) itemView.findViewById(R.id.textview_petcardview_petname);
            mTextViewRating = (TextView) itemView.findViewById(R.id.textview_petcardview_rating);
        }
    }
}
