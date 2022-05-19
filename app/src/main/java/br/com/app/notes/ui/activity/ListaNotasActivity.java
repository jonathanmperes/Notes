package br.com.app.notes.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.app.notes.R;
import br.com.app.notes.dao.NotaDAO;
import br.com.app.notes.model.Nota;
import br.com.app.notes.ui.recyclerview.adapter.ListaNotasAdapter;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        RecyclerView listaNotas = findViewById(R.id.lista_notas_recyclerview);

        NotaDAO dao = new NotaDAO();
        for (int i = 1; i <= 10000; i++) {
            dao.insere(new Nota("Título " + i,
                    "Descrição " + i));
        }
        List<Nota> todasNotas = dao.todos();

        listaNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        listaNotas.setLayoutManager(layoutManager);
    }
}