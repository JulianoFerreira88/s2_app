package br.com.esanparto;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import br.com.databinding.ContentEsanpartoBinding;

public class EsanpartoActivity extends AppCompatActivity {
    private Esanparto parto;
    private ContentEsanpartoBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ContentEsanpartoBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        parto = new Esanparto();
        parto = (Esanparto) getIntent().getExtras().get("parto");
        String nmmatriz = (String) getIntent().getExtras().get("nm_matriz");
        b.txtPartoMatriz.setText(nmmatriz);
        b.txtBV.setText(parto.getNuleitoesabaixo() + "");
        b.txtDtFim.setText(parto.getDataFimParto());
        b.txtDtInicio.setText(parto.getDataInicioParto());
        b.txtDuracao.setText(parto.getDuracao());
        b.txtFuncionario.setText(parto.getNomeFuncionario());
        b.txtHoraInicio.setText(parto.getHoraInicio());
        b.textView24HoraFim.setText(parto.getHoraFim());
        b.txtTipoParto.setText(parto.getTipoDeParto().getNmtipoparto());
        b.txtNV.setText(parto.getNuvivo() + "");
        b.txtNM.setText(parto.getNunatimorto() + "");
        b.txtMUM.setText(parto.getNumumificado() + "");
        b.txtMN.setText(parto.getNumortoaonascer() + "");
        b.txtPesoTotal.setText(parto.getPesoleitegada() + "");
        b.txtPesoMedio.setText(parto.getPesomedionascimento() + "");
    }
}