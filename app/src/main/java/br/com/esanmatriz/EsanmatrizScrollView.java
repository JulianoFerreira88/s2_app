package br.com.esanmatriz;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EsanmatrizScrollView extends ScrollView implements View.OnClickListener {
    private Esanmatriz matriz;
    private LinearLayout linearLayout;

    public EsanmatrizScrollView(Context context, Esanmatriz matriz) {
        super(context);
        this.matriz = matriz;
        this.setOnClickListener(this);
        setMinimumHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setPadding(25, 20, 20, 10);
        linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(getCardView());
        linearLayout.addView(getTextView("Ciclo: " + getMatriz().getCiclos()));
        //linearLayout.addView(getTextView("Dias de Lactação: " + getMatriz().getDiasLactacao()));
        linearLayout.addView(getTextView("******Totais******"), Color.BLUE);
        linearLayout.addView(getTextView("Total Nascidos Totais: " + getMatriz().getTotalNascidosTotais()));
        linearLayout.addView(getTextView("Total Nascidos Vivos: " + getMatriz().getTotalNascidosVivos()));
        linearLayout.addView(getTextView("Total Natimortos: " + getMatriz().getTotalNatimortos()));
        linearLayout.addView(getTextView("Total Mumificados: " + getMatriz().getTotalMumificados()));
        linearLayout.addView(getTextView("Total Mumificados: " + getMatriz().getTotalMumificados()));
        linearLayout.addView(getTextView(""));
        linearLayout.addView(getTextView("******Medias******"), Color.BLUE);
        linearLayout.addView(getTextView("Media Nascidos Totais: " + String.format("%.2f", getMatriz().getMediaNascidosTotais())));
        linearLayout.addView(getTextView("Media Nascidos Vivos: " + String.format("%.2f", getMatriz().getMediaNascidosVivos())));
        linearLayout.addView(getTextView("Media Natimortos: " + String.format("%.2f", getMatriz().getMediaNatimortos())));
        linearLayout.addView(getTextView("Media Mumificados: " + String.format("%.2f", getMatriz().getMediaMumificados())));
        linearLayout.addView(getTextView("Media Morte Ao Nascer: " + String.format("%.2f", getMatriz().getMediaMorteAoNascer())));
        linearLayout.addView(getTextView("Media Baixa Viabilidade: " + String.format("%.2f", getMatriz().getMediaBaixaViabilidade())));
        linearLayout.addView(getTextView(""));
        linearLayout.addView(getTextView("******Percentuais******"), Color.BLUE);


        addView(linearLayout);
    }

    private CardView getCardView() {
        TextView txtIdMatriz = getTextView("Matriz: " + getMatriz().getId1(), Color.BLUE);
        CardView card = new CardView(getContext());
        card.setRadius(10f);
        card.setCardElevation(10f);
        card.setPadding(5, 5, 5, 5);
        card.addView(txtIdMatriz);
        return card;
    }

    private TextView getTextView(String text) {
        TextView txt = new TextView(getContext());
        txt.setText(text);
        txt.setPadding(10, 10, 10, 10);
        return txt;
    }

    private TextView getTextView(String text, int color) {
        TextView txt = new TextView(getContext());
        txt.setText(text);
        txt.setBackgroundColor(color);
        txt.setTextColor(Color.WHITE);
        txt.setPadding(10, 10, 10, 10);
        return txt;
    }

    @Override
    public void onClick(View v) {

    }
}
