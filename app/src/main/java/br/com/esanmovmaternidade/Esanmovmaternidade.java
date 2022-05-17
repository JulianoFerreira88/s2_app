package br.com.esanmovmaternidade;

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
public class Esanmovmaternidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @PrimaryKey(autoGenerate = false)
    private Integer cdmovmaternidade;
    private Date dtregistro;
    private Date dtmovimentacao;
    private Integer qtanimais;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Double peso;
    private String flmaedeleite;
    private Date dtmedianascimento;
    private Double pesomedionascimento;
    private Integer cdpartoorigem;
    private Integer cdpartodestino;
    private Integer cddesmame;

}
