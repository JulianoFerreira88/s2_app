package br.com.esanmatriz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import br.com.R;

public class EsanmatrizCard extends CardView {
    private Esanmatriz matriz;
    private LinearLayout root;
    private LinearLayout.LayoutParams params;

    public EsanmatrizCard(@NonNull Context context, Esanmatriz matriz) {
        super(context);
        init(matriz);

    }

    public EsanmatrizCard(Context context, @Nullable AttributeSet attrs, Esanmatriz matriz) {
        super(context, attrs);
        init(matriz);
    }

    @SuppressLint("ResourceAsColor")
    private void init(Esanmatriz matriz) {
        this.matriz = matriz;
        this.params = new LinearLayout.LayoutParams(-1, -1);
        this.params.setMargins(5, 5, 5, 5);
        this.root = new LinearLayout(getContext());
        this.root.setOrientation(LinearLayout.VERTICAL);
        this.root.setLayoutParams(params);
        this.setLayoutParams(this.params);
        setCardElevation(15f);
        setRadius(15f);
        setCardBackgroundColor(R.color.bg_card_view);
    }
}
