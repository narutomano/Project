package com.example.anton2.finalexerciseclass1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class FinalExercise extends AppCompatActivity {
    private final int MAX_RESULTS = 70;

    private Button btnSearch;
    private EditText etSearch;
    private ListView listViewResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_exercise);
        btnSearch = (Button) findViewById(R.id.button);
        etSearch = (EditText) findViewById(R.id.editText);
        listViewResults = (ListView) findViewById(R.id.listview);
        bindUI();
    }
    private void bindUI() {


        btnSearch.setOnClickListener(view -> {
            String text = etSearch.getText().toString();
            List<String> results = Collections.nCopies(MAX_RESULTS, text);
            showResultsInListView(results);
        });
    }

    private void showResultsInListView(List<String> results) {

        if (adapter == null) {
            adapter = new SearchResultsAdapter(this, results);
            listViewResults.setAdapter(adapter);
        } else {
            adapter.setSearchResults(results);
            adapter.notifyDataSetChanged();
        }

        listViewResults.setOnItemClickListener((adapterView, itemView, pos, id) -> {
            Toast.makeText(this, "List Item Clicked in pos: " + pos,Toast.LENGTH_SHORT).show();
        });
    }
}



