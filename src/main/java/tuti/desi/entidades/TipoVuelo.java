package tuti.desi.entidades;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum TipoVuelo {
	NACIONAL,
    INTERNACIONAL  ; 
    
    
    public static List<String> obtenerTodosLosTipos() {
        return Arrays.stream(values())
                .map(Enum::name)
                .collect(Collectors.toList());
    }
}
