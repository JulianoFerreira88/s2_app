package br.com.esanmaternidade;

import android.os.Build;
import androidx.annotation.RequiresApi;
import br.com.esanmatriz.Esanmatriz;

import java.util.ArrayList;
import java.util.List;

public class Esanmaternidade {
    private List<Esanmatriz> lactantes;

    public Esanmaternidade(List<Esanmatriz> lactantes) {
        this.lactantes = lactantes;
    }

    public double getQuatidadeMatrizes() {
        return lactantes.size();
    }

    public double getSaldoLeitoes() {
        double saldo = 0.0;
        for (Esanmatriz m : lactantes) {
            saldo += m.getSaldo();
        }
        return saldo;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public double getMediaPrimiparas() {
        double total = 0.0;
        for (Esanmatriz marra : getMarras()) {
            total += marra.getSaldo();
        }
        return total / getMarras().size();
    }

    public double getMediaPorPorca() {
        return getSaldoLeitoes() / getQuatidadeMatrizes();
    }

    public double getPercentualAbaixoMedia() {
        double mediaMaternidade = getMediaPorPorca();
        List<Esanmatriz> abaixoMedia = new ArrayList<>();
        for (Esanmatriz matriz : lactantes) {
            if (matriz.getSaldo() < mediaMaternidade) {
                abaixoMedia.add(matriz);
            }
        }
        return (abaixoMedia.size() * 100) / lactantes.size();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Esanmatriz> getMarras() {
        List<Esanmatriz> marras = new ArrayList<>();
        lactantes.forEach(l -> {
            if (l.getCiclos() == 1) {
                marras.add(l);
            }
        });
        return marras;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Esanmatriz> getNaoMarras() {
        List<Esanmatriz> matrizes = new ArrayList<>();
        lactantes.forEach(l -> {
            if (l.getCiclos() != 1) {
                matrizes.add(l);
            }
        });
        return matrizes;
    }
}
