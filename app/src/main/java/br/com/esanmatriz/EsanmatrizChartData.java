package br.com.esanmatriz;

import br.com.esanparto.Esanparto;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@EqualsAndHashCode
@ToString
public class EsanmatrizChartData extends Esanmatriz {
    public EsanmatrizChartData() {
        super();
    }

    public BarData getNascidosVivosBarData() {
        BarData data = new BarData();
        float count = 1f;
        List<BarEntry> entries = new ArrayList<>();
        for (Esanparto parto : this.getPartos()) {
            entries.add(new BarEntry(count, parto.getNuvivo()));
            count += 1f;
        }
        BarDataSet dataSet = new BarDataSet(entries, "");
        data.addDataSet(dataSet);
        return data;
    }
}
