package com.jeff.divax;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    protected void registerLivros(List<Livro> livros){
        livros.add(new Livro("Game of Thrones", "George R. R. Martin", "Batalha dos tronos", 30.00));
        livros.add(new Livro("Game of Thrones", "George R. R. Martin", "Batalha dos tronos", 30.00));
        livros.add(new Livro("Game of Thrones", "George R. R. Martin", "Batalha dos tronos", 30.00));
        livros.add(new Livro("Game of Thrones", "George R. R. Martin", "Batalha dos tronos", 30.00));
        livros.add(new Livro("Game of Thrones", "George R. R. Martin", "Batalha dos tronos", 30.00));
        livros.add(new Livro("Game of Thrones", "George R. R. Martin", "Batalha dos tronos", 30.00));
        livros.add(new Livro("Game of Thrones", "George R. R. Martin", "Batalha dos tronos", 30.00));
        livros.add(new Livro("Game of Thrones", "George R. R. Martin", "Batalha dos tronos", 30.00));
        livros.add(new Livro("Game of Thrones", "George R. R. Martin", "Batalha dos tronos", 30.00));
        livros.add(new Livro("Game of Thrones", "George R. R. Martin", "Batalha dos tronos", 30.00));
        livros.add(new Livro("Game of Thrones", "George R. R. Martin", "Batalha dos tronos", 30.00));
        livros.add(new Livro("Game of Thrones", "George R. R. Martin", "Batalha dos tronos", 30.00));
        livros.add(new Livro("Game of Thrones", "George R. R. Martin", "Batalha dos tronos", 30.00));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);

        List<Livro> livros = new ArrayList<Livro>();
        registerLivros(livros);


        mAdapter = new NossoAdapter(livros, this);
        recyclerView.setAdapter(mAdapter);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);


        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);


    }
}
