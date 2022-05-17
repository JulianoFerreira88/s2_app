package br.com.esancobertura;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import br.com.R;
import br.com.databinding.ContentListCoberturaBinding;
import br.com.esanmatriz.Esanmatriz;

public class EsancoberturaListActivity extends AppCompatActivity {
    private ContentListCoberturaBinding bind;
    private Esanmatriz matriz;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ContentListCoberturaBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        matriz = (Esanmatriz) getIntent().getExtras().get("matriz");
        bind.textView8.setText("Matriz: " + matriz.getId1());
        bind.listCoberturas.setAdapter(new ArrayAdapter<Esancobertura>(this, R.layout.list_view_item, matriz.getCoberturas()));
        bind.listCoberturas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Esancobertura cobertura = (Esancobertura) parent.getItemAtPosition(position);
                Intent i = new Intent(EsancoberturaListActivity.this, EsancoberturaActivity.class);
                i.putExtra("cobertura", cobertura);
                startActivity(i);
            }
        });
    }
}
