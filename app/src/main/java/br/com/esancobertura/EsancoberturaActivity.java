package br.com.esancobertura;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import br.com.databinding.ContentCobreturaBinding;

public class EsancoberturaActivity extends AppCompatActivity {
    private ContentCobreturaBinding bind;
    private Esancobertura cobertura;
    private String nmMatriz;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ContentCobreturaBinding.inflate(getLayoutInflater());
        cobertura = new Esancobertura();
        setContentView(bind.getRoot());
        cobertura = (Esancobertura) getIntent().getExtras().get("cobertura");
        nmMatriz = (String) getIntent().getExtras().get("nm_matriz");
        bind.txtDataCobertura.setText(cobertura.getDtcoberturaString());
        bind.txtFuncionarioCobertura.setText(cobertura.getFuncionario().getNmfuncionario());
        bind.txtMatrizCobertura.setText(nmMatriz);

    }
}
