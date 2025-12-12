package com.olvealmacen.tienda.dao;

import com.olvealmacen.tienda.modelo.Venta;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VentaDAO {

    private final JdbcTemplate jdbcTemplate;

    public VentaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // ===== RowMapper =====
    private final RowMapper<Venta> rowMapper = (rs, rowNum) ->
        new Venta(
                rs.getInt("id_venta"),
                rs.getString("fecha"),
                rs.getDouble("total"),
                rs.getString("metodo_pago"),
                rs.getInt("id_cliente")
        );

    // ===== Listar todas las ventas =====
    public List<Venta> obtenerVentas() {
        String sql = "SELECT * FROM venta";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // ===== Agregar una venta =====
    public boolean agregarVenta(Venta venta) {
        String sql = "INSERT INTO venta (fecha, total, metodo_pago, id_cliente) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                venta.getFecha(),
                venta.getTotal(),
                venta.getMetodoPago(),
                venta.getIdCliente()) > 0;
    }

    // ===== Actualizar una venta =====
    public boolean actualizarVenta(Venta venta) {
        String sql = "UPDATE venta SET fecha = ?, total = ?, metodo_pago = ?, id_cliente = ? WHERE id_venta = ?";
        return jdbcTemplate.update(sql,
                venta.getFecha(),
                venta.getTotal(),
                venta.getMetodoPago(),
                venta.getIdCliente(),
                venta.getIdVenta()) > 0;
    }

    // ===== Eliminar una venta =====
    public boolean eliminarVenta(int id) {
        String sql = "DELETE FROM venta WHERE id_venta = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    // ===== Obtener una venta por ID =====
    public Venta obtenerVentaPorId(int id) {
        String sql = "SELECT * FROM venta WHERE id_venta = ?";
        list<Venta> lista = jdbcTemplate.query(sql, rowMapper, id);
        return lista.isEmpty() ? null : lista.get(0);
    }
}