package com.cooper.reciclagem.enums;

public enum Permissao {
    A("admin"),
    O("operador");

    private String role;

    Permissao(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
