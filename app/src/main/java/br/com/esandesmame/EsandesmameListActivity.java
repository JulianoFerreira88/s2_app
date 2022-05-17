package br.com.esandesmame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import br.com.R;
import br.com.databinding.ContentListDesmameBinding;
import br.com.esanmatriz.Esanmatriz;

public class EsandesmameListActivity extends AppCompatActivity {
    private ContentListDesmameBinding bind;
    private Esanmatriz matriz;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ContentListDesmameBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        matriz = (Esanmatriz) getIntent().getExtras().get("matriz");
        bind.textView15.setText("Matriz: " + matriz.getId1());
        bind.listDesmames.setAdapter(new ArrayAdapter<Esandesmame>(this, R.layout.list_view_item, matriz.getDesmames()));
        bind.listDesmames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Esandesmame desmame = (Esandesmame) parent.getItemAtPosition(position);
                Intent i = new Intent(EsandesmameListActivity.this, EsandesmameActivity.class);
                i.putExtra("desmame", desmame);
                startActivity(i);
            }
        });
    }
}
