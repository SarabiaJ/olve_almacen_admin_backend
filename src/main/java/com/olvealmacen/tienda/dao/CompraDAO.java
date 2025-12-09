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
    public List<Compra> listar() {
        String sql = "SELECT * FROM compra";
        return jdbcTemplate.query(sql, rowMapper);
    }

    // ================= OBTENER POR ID =================
    public Compra obtenerPorId(int id) {
        String sql = "SELECT * FROM compra WHERE id_compra=?";
        List<Compra> lista = jdbcTemplate.query(sql, rowMapper, id);
        return lista.isEmpty() ? null : lista.get(0);
    }

    // ================= AGREGAR =================
    public boolean agregar(Compra c) {
        String sql = "INSERT INTO compra (fecha, id_proveedor, total) VALUES (?,?,?)";
        return jdbcTemplate.update(
                sql,
                c.getFecha(),
                c.getTotal(),
                c.getIdProveedor()
        ) > 0;
    }

    // ================= ACTUALIZAR =================
    public boolean actualizar(Compra c) {
        String sql = "UPDATE compra SET fecha=?, id_proveedor=?, total=? WHERE id_compra=?";
        return jdbcTemplate.update(
                sql,
                c.getId()
                c.getFecha(),
                c.getTotal(),
                c.getIdProveedor()
        ) > 0;
    }

    // ================= ELIMINAR =================
    public boolean eliminar(int id) {
        String sql = "DELETE FROM compra WHERE id_compra=?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}