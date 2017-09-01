package com.joaquinalan.petagram.ui.adapter;

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

public class PetsListAdapter extends RecyclerView.Adapter<PetsListAdapter.PetViewHolder> {
    private List<Pet> mPets = new ArrayList<>();
    private PetsListAdapterListener mListener;
    //private Activity mActivity;

    public PetsListAdapter(Iterable<Pet> pets, PetsListAdapterListener petsListAdapterListener) {
        for (Pet pet : pets) {
            mPets.add(pet);
        }
        //  this.mActivity = activity;
        mListener = petsListAdapterListener;
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
        final Pet pet = mPets.get(position);

        holder.mImageViewPetImage.setImageResource(pet.getImage());
        holder.mTextViewName.setText(pet.getName());
        holder.mTextViewRating.setText(String.valueOf(pet.getRating()));
    }

    @Override
    public int getItemCount() { // Number of elements that my List has.
        return mPets.size();
    }

    public void updatePets() {
//        ListIterator<Pet> listIterator = mPets.listIterator();
//        while (listIterator.hasNext()) {
//            // Need to call next, before set.
//
//            if (listIterator.next().getId() == petRated.getId()) {
//                // Replace item returned from next()
//                listIterator.set(petRated);
//            }
//        }
        notifyDataSetChanged();
    }

    public interface PetsListAdapterListener {
        void onButtonLikeBoneClicked(Pet pet, View view);
    }

    class PetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView mImageViewPetImage;
        private final ImageButton mButtonLikeBone;
        private final TextView mTextViewName;
        private final TextView mTextViewRating;

        PetViewHolder(View itemView) {
            super(itemView);
            mImageViewPetImage = (ImageView) itemView.findViewById(R.id.imageview_petcardview_petimage);
            mButtonLikeBone = (ImageButton) itemView.findViewById(R.id.button_petcardview_likebone);
            mTextViewName = (TextView) itemView.findViewById(R.id.textview_petcardview_petname);
            mTextViewRating = (TextView) itemView.findViewById(R.id.textview_petcardview_rating);

            mButtonLikeBone.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int petPosition = getAdapterPosition();
            final Pet pet = mPets.get(petPosition);

            switch (v.getId()) {
                case R.id.button_petcardview_likebone:
                    mListener.onButtonLikeBoneClicked(pet, v);
                    break;
            }
        }
    }
}
