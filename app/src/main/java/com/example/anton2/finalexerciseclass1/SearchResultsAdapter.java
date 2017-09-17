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
        return results==null?0:results.size();
    }

    @Override
    public Object getItem(int position) {
        return results==null?0:results.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int postion, View view, ViewGroup viewGroup) {
        View rowView = layoutInflater.inflate(R.layout.row,viewGroup,false);
        TextView tvResult = (TextView) rowView.findViewById(R.id.tvSearchResult);
        String searchResult = results.get(postion);
        tvResult.setText(tvResult +" " + postion);


        return rowView ;
    }
}
