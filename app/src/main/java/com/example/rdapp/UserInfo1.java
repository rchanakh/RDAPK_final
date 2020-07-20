package com.example.rdapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class UserInfo1 extends AppCompatActivity {

//
//    private RecyclerView recyclerView;
//    private EditText searchtxt;
//    private ImageView searchbtn;
//
//    private DetailsPostAdapter adapter;
//
//    private DatabaseReference userdatabase;


    DatabaseReference ref;
    ArrayList<MonthPaid> list;
    RecyclerView recyclerView;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info1);
        getSupportActionBar().setTitle("UserInfo");

        ref = FirebaseDatabase.getInstance().getReference("month_paid");
        recyclerView = findViewById(R.id.recycler4);
        searchView = findViewById(R.id.searchvw);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (ref != null)
        {
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists())
                    {
                        list = new ArrayList<>();
                        for (DataSnapshot ds : dataSnapshot.getChildren())
                        {
                            list.add(ds.getValue(MonthPaid.class));
                        }
                        DetailsPostAdapter detailsPostAdapter = new DetailsPostAdapter(list);
                        recyclerView.setAdapter(detailsPostAdapter);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(UserInfo1.this, databaseError.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        }
        if (searchView != null)
        {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    ArrayList<MonthPaid> mylist = new ArrayList<>();
                    for (MonthPaid object : list)
                    {
                        if (object.getAccNo().contains(newText))
                        {
                            mylist.add(object);
                        }
                    }
                    DetailsPostAdapter detailsPostAdapter = new DetailsPostAdapter(mylist);
                    recyclerView.setAdapter(detailsPostAdapter);
                    return true;
                }
            });
        }
    }
}














//        userdatabase = FirebaseDatabase.getInstance().getReference("month_paid");
//
//        searchtxt = (EditText) findViewById(R.id.textsearch);
//        searchbtn = (ImageView) findViewById(R.id.search);
//
//        final String abc = searchtxt.toString();
//
//        recyclerView = (RecyclerView) findViewById(R.id.recycler4);
//
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//
//        searchbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//
//
//                FirebaseRecyclerOptions<MonthPaid> options =
//                        new FirebaseRecyclerOptions.Builder<MonthPaid>()
//                                .setQuery(FirebaseDatabase.getInstance().getReference("month_paid").orderByChild("AccNo").equalTo(abc), MonthPaid.class)
//                                .build();
//
//                adapter = new DetailsPostAdapter(options,this);
//                recyclerView.setAdapter(adapter);
//            }
//        });



//    private void firebaseusersearch()
//    {
//        FirebaseRecyclerAdapter<MonthPaid, UserViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<MonthPaid, UserViewHolder>(
//
//                MonthPaid.class,
//                R.layout.post_3,
//                UserViewHolder.class,
//                userdatabase
//
//        ) {
//            @Override
//            protected void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i, @NonNull MonthPaid monthPaid) {
//
//            }
//
//            @NonNull
//            @Override
//            public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                return null;
//            }
//        };
//    }
//    public class UserViewHolder extends RecyclerView.ViewHolder{
//
//        View mview;
//
//        public UserViewHolder(@NonNull View itemView) {
//            super(itemView);
//            mview =itemView;
//        }
//
//
//    }


