package com.example.anton2.finalexerciseclass1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Anton on 9/17/2017.
 */

public class SearchResultsAdapter extends BaseAdapter{
    private List<String> results;

    private LayoutInflater layoutInflater;

    public SearchResultsAdapter(List<String> data, LayoutInflater layoutInflater) {
        this.results = data;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public Object getItem(int pos) {
        return results.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {

        View rowView = layoutInflater.inflate(R.layout.row, viewGroup, false);
        TextView tvResult = rowView.findViewById(R.id.tvSearchResult);
        String searchResult = results.get(pos);
        tvResult.setText(searchResult + " " + pos);
        return rowView;
    }

    public void setSearchResults(List<String> searchResults) {
        results = searchResults;
    }
}