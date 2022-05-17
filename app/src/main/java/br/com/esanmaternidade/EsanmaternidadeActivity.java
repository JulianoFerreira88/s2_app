package br.com.esanmaternidade;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import br.com.R;
import br.com.databinding.ContentMaternidadeBinding;
import br.com.esanmatriz.Esanmatriz;
import br.com.esanmatriz.EsanmatrizActivity;
import br.com.esanmatriz.EsanmatrizDao;
import br.com.utils.RetrofitBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class EsanmaternidadeActivity extends AppCompatActivity implements Callback<List<Esanmatriz>> {
    private EsanmatrizDao dao;
    private ContentMaternidadeBinding layout;
    private Esanmaternidade maternidade;
    private AlertDialog d;

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout = ContentMaternidadeBinding.inflate(getLayoutInflater());
        setContentView(layout.getRoot());
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Buscando Dados no Servidor!!!");
        dialog.setView(new ProgressBar(this));
        d = dialog.show();

        dao = RetrofitBuilder.build().create(EsanmatrizDao.class);
        dao.findLactantes().enqueue(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onResponse(Call<List<Esanmatriz>> call, Response<List<Esanmatriz>> response) {
        d.hide();
        //d.cancel();
        maternidade = new Esanmaternidade(response.body());
        layout.txtNumMatrizes.setText(String.format("%.2f", maternidade.getQuatidadeMatrizes()));
        layout.txtSaldoLeitoes.setText(String.format("%.2f", maternidade.getSaldoLeitoes()));
        layout.txtMediaPrimiparas.setText(String.format("%.2f", maternidade.getMediaPrimiparas()));
        layout.txtMediaPorPorca.setText(String.format("%.2f", maternidade.getMediaPorPorca()));
        layout.txtPercentAbaixo.setText(String.format("%.2f", maternidade.getPercentualAbaixoMedia()) + "%");
        layout.txtMarras.setText(layout.txtMarras.getText().toString() + " - " + maternidade.getMarras().size());
        layout.txtMatrizes.setText(layout.txtMatrizes.getText().toString() + " - " + maternidade.getNaoMarras().size());
        layout.spMarras.setAdapter(new ArrayAdapter<Esanmatriz>(this, R.layout.list_view_item, maternidade.getMarras()));
        layout.spMatrizes.setAdapter(new ArrayAdapter<Esanmatriz>(this, R.layout.list_view_item, maternidade.getNaoMarras()));
        layout.spMarras.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Esanmatriz matriz = (Esanmatriz) parent.getItemAtPosition(position);
                Intent i = new Intent(EsanmaternidadeActivity.this, EsanmatrizActivity.class);
                i.putExtra("matriz", matriz);
                startActivity(i);
            }
        });
        layout.spMatrizes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Esanmatriz m = (Esanmatriz) parent.getItemAtPosition(position);
                Intent i = new Intent(EsanmaternidadeActivity.this, EsanmatrizActivity.class);
                i.putExtra("matriz", m);
                startActivity(i);
            }
        });
    }

    @Override
    public void onFailure(Call<List<Esanmatriz>> call, Throwable t) {
        d.hide();
        Toast.makeText(this, "Erro ao tentar conectar ao servidor!!", Toast.LENGTH_SHORT).show();
    }

}
