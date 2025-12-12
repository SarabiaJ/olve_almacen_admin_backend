package com.olvealmacen.tienda.modelo;

public class Compra {

    private int id;
    private String fecha;
    private double total;
    private int idProveedor;

    public Compra() {}

    public Compra(int id, String fecha, double total, int idProveedor) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.idProveedor = idProveedor;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    
    public int getIdProveedor() { return idProveedor; }
    public void setIdProveedor(int idProveedor) { this.idProveedor = idProveedor; }

}
