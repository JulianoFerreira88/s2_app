package br.com.esanmatriz;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class EsanmatrizListView extends ListView {
    private List<Esanmatriz> matrizes;

    public EsanmatrizListView(Context context, List<Esanmatriz> matrizes) {
        super(context);
        this.matrizes = matrizes;
        setAdapter(new ArrayAdapter<Esanmatriz>(context, android.R.layout.simple_list_item_1, matrizes));
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Esanmatriz matriz = (Esanmatriz) parent.getItemAtPosition(position);
                Intent i = new Intent(context, EsanmatrizActivity.class);
                i.putExtra("matriz", matriz);
                context.startActivity(i);
            }
        });

    }
}
