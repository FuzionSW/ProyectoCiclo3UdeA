package com.FuzionSW.UdeA.ProyectoCiclo3.entities;

public enum RoleName {
    ADMIN ("Admin"),
    OPERATOR ("Operador");

    private String roleName;

    RoleName() {
    }

    RoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
