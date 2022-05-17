package br.com.esantipoparto;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Esantipoparto implements Serializable {
    private static final long serialVersionUID = 1L;
    @PrimaryKey(autoGenerate = false)
    private Integer cdtipoparto;

    private String nmtipoparto;
}
