package org.fis.grupo1.parcial2.strategy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConteoVotosContext {

    private final Map<String, ConteoVotos<?>> estrategiasConteo;

    public ConteoVotosContext(List<ConteoVotos<?>> strategyList) {
        this.estrategiasConteo= strategyList.stream()
                .collect(Collectors.toMap(
                        s -> s.getClass().getSimpleName(),
                        s -> s
                ));
    }

    @SuppressWarnings("unchecked")
    public <T> T progress(String entidadTerritorial, String codigo) {
        ConteoVotos<T> strategy = (ConteoVotos<T>)  estrategiasConteo.get(entidadTerritorial);
        return strategy.progreso(codigo);
    }

}
