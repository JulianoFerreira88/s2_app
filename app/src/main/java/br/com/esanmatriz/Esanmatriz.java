package br.com.esanmatriz;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import br.com.esanaraca.Esanraca;
import br.com.esancobertura.Esancobertura;
import br.com.esandesmame.Esandesmame;
import br.com.esanparto.Esanparto;
import lombok.*;

import java.io.Serializable;
import java.util.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Esanmatriz implements Serializable {
    private static final long serialVersionUID = 1L;

    @PrimaryKey(autoGenerate = false)
    private Integer cdmatriz;

    private String id1;

    private String id2;

    private Date nascimento;

    private Date entrada;

    private Short ciclos;

    private Short cicloentrada;

    private String estadoreprodutivo;

    private String situacao;

    private String maeDeLeite;

    private Date primeiraCobertura;

    private Date compra;

    private String compragestante;

    private Integer cdraca;
    @Ignore
    private Esanraca raca;
    @Ignore
    private List<Esancobertura> coberturas = new ArrayList<>();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.id1 + " Ciclo: " + this.ciclos);
        return sb.toString();
    }

    public double getTotalNascidosTotais() {
        double total = 0.0;
        for (Esancobertura cobertura : getCoberturas()) {
            for (Esanparto parto : cobertura.getPartos()) {
                total += parto.getNuvivo() + parto.getNunatimorto() + parto.getNumumificado() + parto.getNumortoaonascer();
            }
        }
        return total;
    }

    public double getTotalNascidosVivos() {
        double total = 0.0;
        for (Esancobertura cobertura : getCoberturas()) {
            for (Esanparto parto : cobertura.getPartos()) {
                total += parto.getNuvivo();
            }
        }
        return total;
    }

    public double getTotalNatimortos() {
        double total = 0.0;
        for (Esancobertura cobertura : getCoberturas()) {
            for (Esanparto parto : cobertura.getPartos()) {
                total += parto.getNunatimorto();
            }
        }
        return total;
    }

    public double getTotalMumificados() {
        double total = 0.0;
        for (Esancobertura cobertura : getCoberturas()) {
            for (Esanparto parto : cobertura.getPartos()) {
                total += parto.getNumumificado();
            }
        }
        return total;
    }

    public double getTotalMorteAoNascer() {
        double total = 0.0;
        for (Esancobertura cobertura : getCoberturas()) {
            for (Esanparto parto : cobertura.getPartos()) {
                total += parto.getNumortoaonascer();
            }
        }
        return total;
    }

    public double getTotalBaixaViabilidade() {
        double total = 0.0;
        for (Esancobertura cobertura : getCoberturas()) {
            for (Esanparto parto : cobertura.getPartos()) {
                total += parto.getNuleitoesabaixo();
            }
        }
        return total;
    }

    public double getMediaNascidosTotais() {
        return getTotalNascidosTotais() / getTotalPartos();
    }

    public double getMediaNascidosVivos() {
        return getTotalNascidosVivos() / getTotalPartos();
    }

    public double getMediaNatimortos() {
        return getTotalNatimortos() / getTotalPartos();
    }

    public double getMediaMumificados() {
        return getTotalMumificados() / getTotalPartos();
    }

    public double getMediaMorteAoNascer() {
        return getTotalMorteAoNascer() / getTotalPartos();
    }

    public double getMediaBaixaViabilidade() {
        return getTotalBaixaViabilidade() / getTotalPartos();
    }

    public double getTotalPartos() {
        double totalPartos = 0.0;
        for (Esancobertura cobertura : getCoberturas()) {
            totalPartos += cobertura.getPartos().size();
        }
        return totalPartos;
    }

    public Esanparto getPartoAtual() {
        return getPartos().get(getPartos().size() - 1);
    }

    public double getSaldoAtual() {
        return 0.0;
    }

    public List<Esanparto> getPartos() {
        List<Esanparto> partos = new ArrayList<>();
        for (Esancobertura cobertura : getCoberturas()) {
            for (Esanparto parto : cobertura.getPartos()) {
                partos.add(parto);
            }
        }
        Collections.sort(partos, new Comparator<Esanparto>() {
            @Override
            public int compare(Esanparto o1, Esanparto o2) {
                if (o1.getDtmedianascimento().getTime() > o2.getDtmedianascimento().getTime())
                    return 1;
                if (o1.getDtmedianascimento().getTime() < o2.getDtmedianascimento().getTime())
                    return -1;
                else return 0;
            }
        });
        System.out.println(partos);
        return partos;
    }

    /* public int getDiasLactacao() {
         Date dtmedianascimento = getPartoAtual().getDtmedianascimento();
         System.out.println(dtmedianascimento);
         DateTime dt1 = DateTime.now();
         DateTime dt2 = new DateTime(
                 dtmedianascimento.getYear(),
                 dtmedianascimento.getMonth(),
                 dtmedianascimento.getDay() + 1,
                 dtmedianascimento.getHours(),
                 dtmedianascimento.getMinutes()
         );
         Days days = Days.daysBetween(dt1, dt2);
         return days.getDays();
     }
 */
    public String getEstadoreprodutivoString() {
        if (this.estadoreprodutivo.equals("L")) return "Lactante";
        else if (this.estadoreprodutivo.equals("G")) return "Gestante";
        else return "Vazia";
    }

    public double getPercentualNm() {
        double nascidosTotais = getTotalNascidosTotais();
        double natimortos = getTotalNatimortos();
        double resultado = (natimortos * 100) / nascidosTotais;
        return resultado;
    }

    public double getPercentualMum() {
        double nascidosTotais = getTotalNascidosTotais();
        double mumificados = getTotalMumificados();
        double resultado = (mumificados * 100) / nascidosTotais;
        return resultado;
    }

    public double getPercentualBaixaViabilidade() {
        double nascidosVivos = getTotalNascidosVivos();
        double baixaViabilidade = getTotalBaixaViabilidade();
        double resultado = (baixaViabilidade * 100) / nascidosVivos;
        return resultado;
    }

    public double getPercentualMn() {
        double nascidosTotais = getTotalNascidosTotais();
        double morteAoNascer = getTotalMorteAoNascer();
        double resultado = (morteAoNascer * 100) / nascidosTotais;
        return resultado;
    }

    public List<Esandesmame> getDesmames() {
        List<Esandesmame> desmames = new ArrayList<>();
        for (Esancobertura c : getCoberturas()) {
            for (Esandesmame d : c.getDesmames()) {
                desmames.add(d);
            }
        }
        return desmames;
    }

    public double getSaldo() {
        return getPartoAtual().getSaldo();
    }

    public HashMap<String, Object> getMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("Matriz: ", getId1());
        map.put("Ciclo: ", getCiclos());
        map.put("Estado Reprodutivo: ", getEstadoreprodutivoString());
        map.put("Raça: ", getRaca().getNmraca());
        return map;
    }

    public double getPrevisaoProximoParto() {
        double prob = 0.0;
        return prob;
    }

    public double getNota() {
        double nota = 0.0;
        return nota;
    }
}
