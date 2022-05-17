package br.com.utils;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import br.com.esanaraca.Esanraca;
import br.com.esanaraca.EsanracaDaoRoom;
import br.com.esancobertura.Esancobertura;
import br.com.esandesmame.Esandesmame;
import br.com.esandesmamesparciais.Econdesmamesparciais;
import br.com.esanfuncionario.Esanfuncionario;
import br.com.esanmatriz.Esanmatriz;
import br.com.esanmovanimais.Esanmovanimais;
import br.com.esanmovmaternidade.Esanmovmaternidade;
import br.com.esanparto.Esanparto;
import br.com.esantipoparto.Esantipoparto;

@Database(
        entities = {
                Esanmatriz.class,
                Esanparto.class,
                Esancobertura.class,
                Esanmovanimais.class,
                Esanmovmaternidade.class,
                Esanraca.class,
                Econdesmamesparciais.class,
                Esandesmame.class,
                Esanfuncionario.class,
                Esantipoparto.class
        }, version = 5)
@TypeConverters(
        {Converters.class}
)
public abstract class AppDataBase extends RoomDatabase {
    public abstract EsanracaDaoRoom getEsanracaDaoRoom();
}
