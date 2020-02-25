package com.jeff.divax;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class NossoViewHolder extends RecyclerView.ViewHolder {
    final TextView nome;
    final TextView descricao;
    final TextView preco;
    final TextView autor;

    public NossoViewHolder(View view) {
        super(view);
        nome = view.findViewById(R.id.item_livro_nome);
        descricao = view.findViewById(R.id.item_livro_descricao);
        preco = view.findViewById(R.id.item_livro_preco);
        autor = view.findViewById(R.id.item_livro_autor);

    }
}