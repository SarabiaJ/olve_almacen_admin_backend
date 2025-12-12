package com.olvealmacen.tienda.modelo;

public class Venta {
    private int idVenta;
    private String fecha;
    private double total;
    private String metodoPago;
    private int idCliente;

    public Venta() { }

    public Venta(int idVenta, String fecha, double total, String metodoPago, int idCliente) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = total;
        this.metodoPago = metodoPago;
        this.idCliente = idCliente;
    }

    public int getIdVenta() { return idVenta; }
    public void setIdVenta(int idVenta) { this.idVenta = idVenta; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
}