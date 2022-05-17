package br.com.esanmovanimais;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Esanmovanimais implements Serializable {
    private static final long serialVersionUID = 1L;
    @PrimaryKey(autoGenerate = false)
    private Integer cdmovanimais;
    private Integer cdmovanimais2;
    private String fltipo;
    private String fltipovenda;
    private Date dtregistro;
    private Date dtmovimentacao;
    private Integer qtanimais;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Double peso;
    private Date dtnascimento;
    private Integer cdrelacionado;
    private Date hora;
    private String flpalm;
    private Double valor;
    private String nubaia;
    private Integer cdlote2;
    private Integer cdcargaanimal;
    private Integer qtanimaisposabate;
    private String flacertomaternidadeagriness;
    private String observacao;
    private String guid;
}
