package com.olvealmacen.tienda.dao;

import com.olvealmacen.tienda.modelo.Compra;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompraDAO {

    private final JdbcTemplate jdbcTemplate;

    public CompraDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Compra> rowMapper = (rs, rowNum) ->
            new Compra(
                    rs.getInt("id_compra"),
                    rs.getString("fecha"),
                    rs.getDouble("total"),
                    rs.getInt("id_proveedor")
            );

    // ================= LISTAR =================
    public List<Compra> obtenerCompras() {
        String sql = "SELECT * FROM compra";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // ================= OBTENER POR ID =================
    public Compra obtenerCompraPorId(int id) {
        String sql = "SELECT * FROM compra WHERE id_compra = ?";
        List<Compra> lista = jdbcTemplate.query(sql, rowMapper, id);
        return lista.isEmpty() ? null : lista.get(0);
    }

    // ================= AGREGAR =================
    public boolean agregarCompra(Compra compra) {
        String sql = "INSERT INTO compra (fecha, total, id_proveedor) VALUES (?,?,?)";
        return jdbcTemplate.update(sql,
                compra.getFecha(),
                compra.getTotal(),
                compra.getIdProveedor()) > 0;
    }

    // ================= ACTUALIZAR =================
    public boolean actualizarCompra(Compra compra) {
        String sql = "UPDATE compra SET fecha = ?, total = ?, id_proveedor = ? WHERE id_compra = ?";
        return jdbcTemplate.update(sql,
                compra.getFecha(),
                compra.getTotal(),
                compra.getIdProveedor()
                compra.getId()) > 0;
    }

    // ================= ELIMINAR =================
    public boolean eliminarCompra(int id) {
        String sql = "DELETE FROM compra WHERE id_compra = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}