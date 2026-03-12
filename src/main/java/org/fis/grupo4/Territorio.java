package org.fis.grupo4;

public class Territorio {
    private String departamento;
    private String municipío;

    // private List<PuestoDeVotacion> puestosDeVotacion;


    public Territorio(String departamento, String municipío) {
        this.departamento = departamento;
        this.municipío = municipío;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipío() {
        return municipío;
    }

    public void setMunicipío(String municipío) {
        this.municipío = municipío;
    }
}
