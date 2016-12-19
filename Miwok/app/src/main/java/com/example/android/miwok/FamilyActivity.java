package com.example.android.miwok;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        List<Word> words = new ArrayList<>();
        words.add(new Word("father", "әpә"));
        words.add(new Word("mother", "әṭa"));
        words.add(new Word("son", "angsi"));
        words.add(new Word("daughter", "tune"));
        words.add(new Word("older brother", "taachi"));
        words.add(new Word("younger brother", "chalitti"));
        words.add(new Word("older sister", "teṭe"));
        words.add(new Word("younger sister", "kolliti"));
        words.add(new Word("grandmother", "ama"));
        words.add(new Word("grandfather", "paapa"));

        WordAdapter<Word> wordAdapter = new WordAdapter<>(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);
    }
}
