package br.com.esandesmame;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import lombok.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Esandesmame implements Serializable {

    private static final long serialVersionUID = 1L;
    @PrimaryKey(autoGenerate = false)
    private Integer cddesmame;

    private Date dtregistro;

    private Date dtdesmame;

    private Integer desmamados;

    private Integer recebidos;

    private Integer doados;

    private Integer mortos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    private Double pesoleitegada;

    private Double pesomatriz;

    private Double espessuratoucinhomatriz;

    private String fldesmameparcial;

    private String obs;

    private Integer ciclo;

    private String flgeradoautomaticamente;

    private String flpalm;

    private String nubaia;

    private Integer scorecorporal;

    private Integer nudesclassificado;

    private String guid;

    private Integer cdcobertura;

    private Integer cdmatriz;

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            final String data = sdf.format(dtdesmame);
            return "Data: " + data + " - Quantidade: " + this.desmamados;
        } catch (Exception e) {
            return "Data: " + dtdesmame + " - Quantidade: " + this.desmamados;
        }
    }

    public double getPesoMedioDesmame() {
        return this.pesoleitegada / this.desmamados;
    }

    public String getDtdesmameString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = "";
        try {
            date = sdf.format(this.dtdesmame);
        } catch (Exception e) {

        }
        return date;
    }
}

