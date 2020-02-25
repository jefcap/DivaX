package com.jeff.divax;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NossoAdapter extends RecyclerView.Adapter {

    private List<Livro> livros;
    private Context context;

    public NossoAdapter(List<Livro> livros, Context context) {
        this.livros = livros;
        this.context = context;

    }

    @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_livro, parent, false);
        NossoViewHolder holder = new NossoViewHolder(view);

        return holder; }

    @Override public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        NossoViewHolder holder = (NossoViewHolder) viewHolder;
        Livro livro = livros.get(position) ;
        holder.nome.setText(livro.getNomeLivro());
        holder.descricao.setText(livro.getDescricao());
        holder.autor.setText(livro.getNomeAutor());
        holder.preco.setText(Double.toString(livro.getPreco()));

    }

    @Override public int getItemCount() { return livros.size(); } }