package br.com.esandesmame;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import br.com.R;
import br.com.databinding.ContentDesmameBinding;

public class EsandesmameActivity extends AppCompatActivity {
    private Esandesmame desmame;
    private String nmMatriz;
    private ContentDesmameBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ContentDesmameBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        desmame = (Esandesmame) getIntent().getExtras().get("desmame");
        nmMatriz = (String) getIntent().getExtras().get("nm_matriz");
        bind.txtDataDesmame.setText(desmame.getDtdesmameString());
        bind.txtMatrizDesmame.setText(nmMatriz);
        bind.txtQuantidade.setText(desmame.getDesmamados() + "");
        bind.txtPesoMedioDesmame.setText(String.format("%2f", desmame.getPesoMedioDesmame()));
    }
}