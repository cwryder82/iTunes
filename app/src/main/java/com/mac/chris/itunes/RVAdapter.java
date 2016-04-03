package com.mac.chris.itunes;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mac.chris.itunes.pojos.Result;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ItemViewHolder>{

    List<Result> results;
    Context mContext;

    public RVAdapter(Context c, List<Result> r) {
        mContext = c;
        results = r;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        ItemViewHolder cvh = new ItemViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int i) {
        holder.artist.setText(results.get(i).getArtistName().toString());
        holder.collection.setText(results.get(i).getCollectionName().toString());
        holder.song.setText(results.get(i).getTrackName().toString());
        holder.genre.setText(results.get(i).getPrimaryGenreName().toString());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;

        TextView artist;
        TextView collection;
        TextView song;
        TextView genre;


        public ItemViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cardView);

            artist = (TextView) itemView.findViewById(R.id.cv_artist_name);
            collection = (TextView) itemView.findViewById(R.id.cv_collection_name);
            song = (TextView) itemView.findViewById(R.id.cv_song);
            genre = (TextView) itemView.findViewById(R.id.cv_genre);

        }
    }
}
