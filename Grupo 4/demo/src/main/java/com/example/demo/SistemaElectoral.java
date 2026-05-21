package com.example.demo;

import com.example.demo.Singleton.AutoridadElectoral;
import lombok.Data;

@Data
public class SistemaElectoral {
    private AutoridadElectoral autoridadElectoral;

    public SistemaElectoral(){
        this.autoridadElectoral = AutoridadElectoral.getInstance();
    }
}
