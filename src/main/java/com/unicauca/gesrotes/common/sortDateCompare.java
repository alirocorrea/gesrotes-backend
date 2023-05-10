package com.unicauca.gesrotes.common;

import java.util.Comparator;

import com.unicauca.gesrotes.domain.Ciclo;

public class sortDateCompare  implements Comparator<Ciclo>{

    @Override
    public int compare(Ciclo arg0, Ciclo arg1) {
        return arg0.getFechaInicio().compareTo(arg1.getFechaInicio());
    }
    
}
