package br.com.esandesmamesparciais;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Econdesmamesparciais implements Serializable {

    private static final long serialVersionUID = 1L;
    @PrimaryKey(autoGenerate = false)
    private Integer cdcobertura;

    private Integer nudesmamado;

    private Double pesoleitegada;

}
