package com.rabbithole.tutorial_docker.data;

import java.io.Serializable;

public class Item implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Long id;

    private Long codigo;
    
    private String produto;
    
    private Long quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
