package br.com.esanparto;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import br.com.esanfuncionario.Esanfuncionario;
import br.com.esanmovanimais.Esanmovanimais;
import br.com.esanmovmaternidade.Esanmovmaternidade;
import br.com.esantipoparto.Esantipoparto;
import lombok.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Esanparto implements Serializable {

    private static final long serialVersionUID = 1L;
    @PrimaryKey(autoGenerate = false)
    private Integer cdparto;

    private Date dtregistro;

    private Date dtinicioparto;

    private Date dtfimparto;

    private Date horainicioparto;

    private Date horafimparto;

    private Double pesomatriz;

    private Double espessuratoucinhomatriz;

    private Double pesoleitegada;

    private Integer numumificado;

    private Integer nunatimorto;

    private Integer numortoaonascer;

    private Integer nuvivo;

    private Integer nudoado;

    private Integer nurecebido;

    private Double pesomedionascimento;

    private Date dtmedianascimento;

    private String obs;

    private Integer ciclo;

    private String flpalm;

    private String nubaia;

    private Integer scorecorporal;

    private Integer nuleitoesabaixo;

    private Integer nuleitoesentre;

    private Integer nuleitoesacima;

    private String duracao;

    private String guid;

    private Integer cdmatriz;

    private Integer cdfuncionario;

    private Integer cdtipoparto;

    private Integer cdcobertura;

    @Ignore
    private Esanfuncionario funcionario;
    @Ignore
    private Esantipoparto tipoDeParto;
    @Ignore
    private List<Esanmovanimais> movimentacoes;
    @Ignore
    private List<Esanmovmaternidade> saidas;
    @Ignore
    private List<Esanmovmaternidade> entradas;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            final String data = sdf.format(dtmedianascimento);
            sb.append("Data: " + data + "\n");
            sb.append("Início: " + horainicioparto.toString() + "\n");
            sb.append("Fim: " + horafimparto.toString() + "\n");
            sb.append("Vivos: " + nuvivo + "\n");
            return sb.toString();
        } catch (Exception e) {
            sb.append("Data: " + dtmedianascimento).append("\n").append("\n");
            sb.append("Início: " + horainicioparto.toString()).append("\n");
            sb.append("Fim: " + horafimparto.toString()).append("\n");
            sb.append("Vivos: " + nuvivo).append("\n");
            return sb.toString();
        }
    }

    public String getDataFimParto() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.format(dtfimparto);
        } catch (Exception e) {
            return dtfimparto.toString();
        }
    }

    public String getDataInicioParto() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.format(dtinicioparto);
        } catch (Exception e) {
            return dtinicioparto.toString();
        }
    }

    public String getHoraInicio() {
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        try {
            return sdf.format(horainicioparto);
        } catch (Exception e) {
            return horainicioparto.toString();
        }
    }

    public String getHoraFim() {
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        try {
            return sdf.format(horafimparto);
        } catch (Exception e) {
            return horafimparto.toString();
        }
    }

    public String getNomeFuncionario() {
        if (funcionario == null) {
            funcionario = new Esanfuncionario();
            funcionario.setNmfuncionario("Sem Funcionário");
        } else if (funcionario.getNmfuncionario() == null) {
            funcionario.setNmfuncionario("Sem Funcionário");
        }
        return funcionario.getNmfuncionario();
    }

    public double getSaldo() {
        double saldo = (nuvivo + nurecebido) - nudoado;
        return saldo;
    }
}

