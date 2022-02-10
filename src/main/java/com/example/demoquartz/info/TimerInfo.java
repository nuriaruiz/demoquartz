package com.example.demoquartz.info;

import lombok.Data;

@Data
public class TimerInfo {
    private int totalFireCount; // cuantas veces se va a ejecutar
    private boolean runForever; // indica si se va a ejecutar para siempre
    private long repeatIntervalMs; // tiempo entre ejecuciones
    private long initialOffsetMs; // tiempo hasta la primera ejecucion
    private String callbackData; // informacion que le pasaremos al job
}
