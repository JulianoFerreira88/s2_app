package br.com.esanmatriz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import br.com.databinding.ContentMatrizBinding;
import br.com.esancobertura.EsancoberturaListActivity;
import br.com.esandesmame.EsandesmameListActivity;
import br.com.esanparto.ListPartoActivity;

public class EsanmatrizActivity extends AppCompatActivity {
    private Esanmatriz matriz = new Esanmatriz();
    private ContentMatrizBinding bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ContentMatrizBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        matriz = (Esanmatriz) getIntent().getExtras().get("matriz");
        bind.cicloMatriz.setText(matriz.getCiclos().toString());
        bind.txtEstado.setText(matriz.getEstadoreprodutivoString());
        bind.txtMatriz.setText(matriz.getId1());
        bind.txtRaca.setText(matriz.getRaca().getNmraca());
        bind.txtMediaNascidosTotais.setText(String.format("%.2f", matriz.getMediaNascidosTotais()));
        bind.txtMediaVivos.setText(String.format("%.2f", matriz.getMediaNascidosVivos()));
        bind.txtPercentualNm.setText(String.format("%.2f", matriz.getPercentualNm()) + "%");
        bind.txtTotalNascidosTotais.setText(String.format("%.2f", matriz.getTotalNascidosTotais()));
        bind.txtTotalNascidosVivos.setText(String.format("%.2f", matriz.getTotalNascidosVivos()));
        bind.txtTotalNatimortos.setText(String.format("%.2f", matriz.getTotalNatimortos()));
        bind.txtTotalMumificados.setText(String.format("%.2f", matriz.getTotalMumificados()));
        bind.txtTotalMorteAoNascer.setText(String.format("%.2f", matriz.getTotalMorteAoNascer()));
        bind.txtPercentualMum.setText(String.format("%.2f", matriz.getPercentualMum()) + "%");
        bind.txtPercentualBaixaViabilidade.setText(String.format("%.2f", matriz.getPercentualBaixaViabilidade()) + "%");
        bind.txtPercentualMn.setText(String.format("%.2f", matriz.getPercentualMn()) + "%");
        bind.txtNota.setText(String.format("%.2f", matriz.getNota()));
        bind.txtProbabilidadeAbaixo.setText(String.format("%.2f", matriz.getPrevisaoProximoParto()));
        bind.btnPartos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EsanmatrizActivity.this, ListPartoActivity.class);

                i.putExtra("matriz", matriz);
                startActivity(i);
            }
        });
        bind.btnCoberturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EsanmatrizActivity.this, EsancoberturaListActivity.class);
                i.putExtra("matriz", matriz);
                startActivity(i);
            }
        });
        bind.btnDesmames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EsanmatrizActivity.this, EsandesmameListActivity.class);
                i.putExtra("matriz", matriz);
                startActivity(i);
            }
        });
        bind.btnGraficos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EsanmatrizActivity.this, EsanmatrizGraficosActivity.class);
                i.putExtra("matriz", matriz);
                startActivity(i);
            }
        });
    }


}
