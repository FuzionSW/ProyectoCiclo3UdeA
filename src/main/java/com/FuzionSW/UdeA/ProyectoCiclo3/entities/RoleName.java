package com.FuzionSW.UdeA.ProyectoCiclo3.entities;

public enum RoleName {
    ADMIN ("Administrador"),
    OPERATOR ("Operador");

    private final String displayValue;

    private RoleName(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}