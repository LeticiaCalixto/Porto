package br.inatel.containers.model;

public class Container {

    private Long id;
    private String cliente;
    private String numeroContainer;
    public int tipo;
    public String status;
    public String categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNumeroContainer() {
        return numeroContainer;
    }

    public void setNumeroContainer(String numeroContainer) {
        this.numeroContainer = numeroContainer;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
