
package com.example.roomwordssample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WordListAdapter
        extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private List<Word> mWords = new ArrayList<>();

    static class WordViewHolder extends RecyclerView.ViewHolder {

        private final TextView wordItemView;

        WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);

        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(
            @NonNull WordViewHolder holder, int position) {

        Word current = mWords.get(position);
        holder.wordItemView.setText(current.getWord());
    }

    @Override
    public int getItemCount() {
        return mWords.size();
    }

    public void setWords(List<Word> words) {
        mWords = words != null ? words : new ArrayList<>();
        notifyDataSetChanged();
    }
}
