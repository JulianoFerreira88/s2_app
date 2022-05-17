package br.com.entity;

import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import br.com.R;
import br.com.databinding.ContentBasicEntitieBinding;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class BasicEntityActivity extends AppCompatActivity {
    private ContentBasicEntitieBinding bind;
    private HashMap map;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ContentBasicEntitieBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, -1);
        params.setMargins(10, 10, 10, 10);
        params.weight = 1f;
        map = (HashMap) getIntent().getExtras().get("entity");
        map.forEach((BiConsumer<String, Object>) (s, o) -> {
            LinearLayout ll = new LinearLayout(getApplicationContext());
            ll.setOrientation(LinearLayout.HORIZONTAL);

            TextView txtKey = new TextView(getApplicationContext());
            txtKey.setText(s);
            TextView txtValue = new TextView(getApplicationContext());
            txtValue.setText(o.toString());

            ll.addView(txtKey, params);
            ll.addView(txtValue, params);

            bind.basicRoot.addView(ll, params);
        });

    }
}