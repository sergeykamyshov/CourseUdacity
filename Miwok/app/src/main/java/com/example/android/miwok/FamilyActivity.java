package com.example.android.miwok;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new FamilyFragment())
                .commit();
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int itemId = item.getItemId();
//        switch (itemId) {
//            case android.R.id.home:
//                startActivity(new Intent(this, MainActivity.class));
//                return true;
//            default:
//                super.onOptionsItemSelected(item);
//        }
//        return false;
//    }
}
