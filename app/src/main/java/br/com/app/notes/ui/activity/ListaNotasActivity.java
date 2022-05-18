package br.com.app.notes.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import br.com.app.notes.R;
import br.com.app.notes.dao.NotaDAO;
import br.com.app.notes.model.Nota;
import br.com.app.notes.ui.adapter.ListaNotasAdapter;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        ListView listaNotas = findViewById(R.id.listView);

        NotaDAO dao = new NotaDAO();
        for (int i = 1; i <= 10000; i++) {
            dao.insere(new Nota("Título " + i,
                    "Descrição " + i));
        }
        List<Nota> todasNotas = dao.todos();

        listaNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));
    }
}