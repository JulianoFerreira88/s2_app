package br.com.esancobertura;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import br.com.esandesmame.Esandesmame;
import br.com.esandesmamesparciais.Econdesmamesparciais;
import br.com.esanfuncionario.Esanfuncionario;
import br.com.esanparto.Esanparto;
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
public class Esancobertura implements Serializable {

    private static final long serialVersionUID = 1L;
    @PrimaryKey(autoGenerate = false)
    private Integer cdcobertura;

    private Date dtregistro;

    private Date dtcobertura;

    private Date horacobertura;

    private Integer ciclo;

    private String flmaedeleite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    private Double pesomatriz;

    private Double espessuratoucinhomatriz;

    private Integer idcobertura;

    private String flinseminacao;

    private String obs;

    private String flpalm;

    private String flcobertanalactacao;

    private String nubaia;

    private Integer scorecorporal;

    private String flcompragestante;

    private String guid;

    private Integer cdmatriz;

    private Integer cdfuncionario;
    @Ignore
    private Esanfuncionario funcionario;
    @Ignore
    private List<Esanparto> partos;
    @Ignore
    private List<Esandesmame> desmames;
    @Ignore
    private List<Econdesmamesparciais> desmamesParcias;

    public Esanfuncionario getFuncionario() {
        if (funcionario == null) {
            return new Esanfuncionario();
        }
        return funcionario;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            final String data = sdf.format(dtcobertura);
            return "Data: " + data;
        } catch (Exception e) {
            return "Data: " + dtcobertura;
        }
    }

    public String getDtcoberturaString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            String date = sdf.format(this.dtcobertura);
            return date;
        } catch (Exception e) {
            return null;
        }
    }
}
