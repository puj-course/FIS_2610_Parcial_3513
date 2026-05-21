package com.example.demo.Singleton;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AutoridadElectoral {
    private static AutoridadElectoral autoridadElectoral;

    private AutoridadElectoral(){}

    public static AutoridadElectoral getInstance(){
        if(autoridadElectoral == null){
            autoridadElectoral = new AutoridadElectoral();
        }
        return autoridadElectoral;
    }
}
