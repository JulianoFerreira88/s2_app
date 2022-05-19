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

    public BarData getNatimortosBarData() {
        BarData data = new BarData();
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1f, 12.50f));
        entries.add(new BarEntry(2f, 11.50f));
        entries.add(new BarEntry(3f, 12.75f));
        entries.add(new BarEntry(4f, 13.20f));
        entries.add(new BarEntry(5f, 12.45f));
        data.addDataSet(new BarDataSet(entries, ""));
        return data;
    }

    public BarData getNascidosTotaisBarData() {
        List<BarEntry> entries = new ArrayList<>();
        float count = 1f;
        for (Esanparto parto : getPartos()) {
            BarEntry entry = new BarEntry(count, (float) parto.getNascidosTotais());
            entries.add(entry);
            count += 1f;
        }
        BarDataSet dataSet = new BarDataSet(entries, "label");
        BarData data = new BarData(dataSet);
        return data;
    }

    public BarData getMumificadosBarData() {
        return null;
    }
}
