package com.olvealmacen.tienda.controlador;

import com.google.gson.Gson;
import com.olvealmacen.tienda.modelo.Compra;
import com.olvealmacen.tienda.services.CompraService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://sarabiaj.github.io")
@RestController
@RequestMapping("/api/compras")
public class CompraControlador {

    private final CompraService compraService;
    private final Gson gson;

    public CompraControlador(CompraService compraService) {
        this.compraService = compraService;
        this.gson = new Gson();
    }

    @GetMapping({"", "/listar"})
    public String listarCompras() {
        List<Compra> lista = compraService.obtenerCompras();
        return gson.toJson(lista);
    }

    @PostMapping
    public String insertar(@RequestBody Compra c) {
        boolean ok = compraService.agregarCompra(c);
        return "{\"success\": " + ok + "}";
    }

    @PutMapping("/{id}")
    public String actualizar(@PathVariable int id, @RequestBody Compra c) {
        c.setId(id);
        boolean ok = compraService.actualizarCompra(c);
        return "{\"success\": " + ok + "}";
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        boolean ok = compraService.eliminarCompra(id);
        return "{\"success\": " + ok + "}";
    }
}