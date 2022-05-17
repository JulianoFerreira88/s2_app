package br.com.esanparto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import br.com.R;
import br.com.databinding.ContentListPartoBinding;
import br.com.esanmatriz.Esanmatriz;

public class ListPartoActivity extends AppCompatActivity {
    private ContentListPartoBinding bind;
    private Esanmatriz matriz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ContentListPartoBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        matriz = (Esanmatriz) getIntent().getExtras().get("matriz");
        bind.txtIdMatriz.setText("Matriz: " + matriz.getId1());
        bind.listPartos.setAdapter(new ArrayAdapter<Esanparto>(this, R.layout.list_view_item, matriz.getPartos()));
        bind.listPartos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Esanparto parto = (Esanparto) parent.getItemAtPosition(position);
                Intent i = new Intent(ListPartoActivity.this, EsanpartoActivity.class);
                i.putExtra("parto", parto);
                startActivity(i);
            }
        });
    }
}