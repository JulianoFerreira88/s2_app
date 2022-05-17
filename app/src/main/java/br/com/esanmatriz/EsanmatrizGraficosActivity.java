package br.com.esanmatriz;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import br.com.R;
import br.com.databinding.ContentGraficoMatrizBinding;

public class EsanmatrizGraficosActivity extends AppCompatActivity {
    private ContentGraficoMatrizBinding bind;
    private EsanmatrizChartData matriz;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_grafico_matriz);
        bind = ContentGraficoMatrizBinding.inflate(getLayoutInflater());
        matriz = (EsanmatrizChartData) getIntent().getExtras().get("matriz");

        bind.graficoNascidosVivos.setData(matriz.getNascidosVivosBarData());
    }
}
