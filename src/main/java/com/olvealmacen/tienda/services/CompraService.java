package com.olvealmacen.tienda.services;

import com.olvealmacen.tienda.dao.CompraDAO;
import com.olvealmacen.tienda.modelo.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    private final CompraDAO compraDAO;

    @Autowired
    public CompraService(CompraDAO compraDAO) {
        this.compraDAO = compraDAO;
    }

    public List<Compra> obtenerCompras() {
        return compraDAO.obtenerCompras();
    }

    public Compra obtenerCompraPorId(int id) {
        return compraDAO.obtenerCompraPorId(id);
    }

    public boolean agregarCompra(Compra compra) {
        return compraDAO.agregarCompra(compra);
    }

    public boolean actualizarCompra(Compra compra) {
        return compraDAO.actualizarCompra(compra);
    }

    public boolean eliminarCompra(int id) {
        return compraDAO.eliminarCompra(id);
    }
}
