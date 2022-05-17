package br.com.utils;

import android.content.Context;
import androidx.room.Room;

public class RoomDataBaseBuilder {
    public static AppDataBase getAppDataBase(Context context) {
        return Room.databaseBuilder(context, AppDataBase.class, "db").build();
    }
}
