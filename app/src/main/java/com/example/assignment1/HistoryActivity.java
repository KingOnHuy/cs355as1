package com.example.assignment1;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class HistoryActivity extends AppCompatActivity {
    private DBManager dbManager;
    private SimpleCursorAdapter adapter;

    final String[] from = new String[] {
            DatabaseHelper.SALES,
            DatabaseHelper.SHARE_PERCENTAGE,
            DatabaseHelper.SALES_MINUS_SHARE,
            DatabaseHelper.SALES_SHARE
    };

    final int[] to = new int[] {
            R.id.salesColumn,
            R.id.sharePercenColumn,
            R.id.salesMinusShareColumn,
            R.id.salesShareColumn
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("History");
        setContentView(R.layout.activity_history);

        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        final ListView historyListView = (ListView) findViewById(R.id.historyList);
        historyListView.setEmptyView(findViewById(R.id.empty));

        adapter = new SimpleCursorAdapter(this, R.layout.list, cursor, from, to, 0);

        adapter.notifyDataSetChanged();

        historyListView.setAdapter(adapter);
    }
}
