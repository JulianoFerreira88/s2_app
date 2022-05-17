package br.com.chart;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import br.com.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_chart);
        BarChart chart = (BarChart) findViewById(R.id.barChart);

        BarData data = new BarData();
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1f, 12.5f));
        BarDataSet dataSet = new BarDataSet(entries, "DataSet");
        data.addDataSet(dataSet);
        chart.setData(data);
    }
}
