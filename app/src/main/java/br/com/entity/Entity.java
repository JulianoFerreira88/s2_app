package br.com.entity;

import android.os.Parcelable;

import java.util.HashMap;

public interface Entity extends Parcelable {
    HashMap<String, Object> getMap();
}
