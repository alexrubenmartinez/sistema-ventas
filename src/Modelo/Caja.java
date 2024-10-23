/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Caja {
    private int id;
    private int usuarioId;
    private BigDecimal montoInicial;
    private BigDecimal montoFinal;
    private LocalDateTime fechaApertura;
    private LocalDateTime fechaCierre;
    private EstadoCaja estado;
    private BigDecimal totalVentas;
    private String observaciones;

    // Enum para el estado de la caja
    public enum EstadoCaja {
        ABIERTA("abierta"),
        CERRADA("cerrada");

        private String valor;

        EstadoCaja(String valor) {
            this.valor = valor;
        }

        public String getValor() {
            return valor;
        }
    }

    // Constructor por defecto
    public Caja() {
        this.estado = EstadoCaja.ABIERTA;
        this.totalVentas = BigDecimal.ZERO;
    }

    public Caja(int id, int usuarioId, BigDecimal montoInicial, BigDecimal montoFinal, LocalDateTime fechaApertura, LocalDateTime fechaCierre, EstadoCaja estado, BigDecimal totalVentas, String observaciones) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.montoInicial = montoInicial;
        this.montoFinal = montoFinal;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
        this.totalVentas = totalVentas;
        this.observaciones = observaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

   
    
    public BigDecimal getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(BigDecimal montoInicial) {
        this.montoInicial = montoInicial;
    }

    public BigDecimal getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(BigDecimal montoFinal) {
        this.montoFinal = montoFinal;
    }

    public LocalDateTime getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDateTime fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public LocalDateTime getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDateTime fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public EstadoCaja getEstado() {
        return estado;
    }

    public void setEstado(EstadoCaja estado) {
        this.estado = estado;
    }

    public BigDecimal getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(BigDecimal totalVentas) {
        this.totalVentas = totalVentas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Caja{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", montoInicial=" + montoInicial +
                ", montoFinal=" + montoFinal +
                ", fechaApertura=" + fechaApertura +
                ", fechaCierre=" + fechaCierre +
                ", estado=" + estado +
                ", totalVentas=" + totalVentas +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}