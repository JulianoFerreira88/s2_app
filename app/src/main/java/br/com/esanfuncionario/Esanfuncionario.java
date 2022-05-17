package br.com.esanfuncionario;

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
public class Esanfuncionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @PrimaryKey(autoGenerate = false)
    private Integer cdfuncionario;

    private String nmfuncionario = "";

    private Double vlsalario;

    private Double peencargo;

    private String flativo;

    private Date hrtrabalhodia;

    private String guid;

}

