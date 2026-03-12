package org.fis;

import java.util.List;

public class SistemaG4 {
    private List<ProcesosElectoralesG4> procesosElectorales;

    public SistemaG4(List<ProcesosElectoralesG4> procesosElectorales) {
        this.procesosElectorales = procesosElectorales;
    }

    public List<ProcesosElectoralesG4> getProcesosElectorales() {
        return procesosElectorales;
    }
    

    public void setProcesosElectorales(List<ProcesosElectoralesG4> procesosElectorales) {
        this.procesosElectorales = procesosElectorales;
    }
}
