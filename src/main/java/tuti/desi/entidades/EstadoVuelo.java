package tuti.desi.entidades;

public enum EstadoVuelo {
	NORMAL("Normal"),
	REPROGRAMADO("Reprogramado"),
	CANCELADO("Cancelado");
	
	
    private final String estado;
	
	EstadoVuelo(String estado) {
	        this.estado = estado;
	    }
	
	 public String getEstado() {
        return estado;
    }

}
