package com.olvealmacen.tienda.services;

import com.olvealmacen.tienda.dao.VentaDAO;
import com.olvealmacen.tienda.modelo.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    private final VentaDAO ventaDAO;

    @Autowired
    public VentaService(VentaDAO ventaDAO) {
        this.ventaDAO = ventaDAO;
    }

    // Obtener todas las ventas
    public List<Venta> obtenerVentas() {
        return ventaDAO.obtenerVentas();
    }

    // Obtener venta por ID
    public Venta obtenerVentaPorId(int id) {
        return ventaDAO.obtenerVentaPorId(id);
    }

    // Agregar venta
    public boolean agregarVenta(Venta venta) {
        return ventaDAO.agregarVenta(venta);
    }

    // Actualizar venta
    public boolean actualizarVenta(Venta venta) {
        return ventaDAO.actualizarVenta(venta);
    }

    // Eliminar venta
    public boolean eliminarVenta(int id) {
        return ventaDAO.eliminarVenta(id);
    }
}