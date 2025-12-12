package com.olvealmacen.tienda.controlador;

import com.google.gson.Gson;
import com.olvealmacen.tienda.modelo.Venta;
import com.olvealmacen.tienda.services.VentaService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://sarabiaj.github.io")
@RestController
@RequestMapping("/api/ventas")
public class VentaControlador {

    private final VentaService ventaService;
    private final Gson gson;

    public VentaControlador(VentaService ventaService) {
        this.ventaService = ventaService;
        this.gson = new Gson();
    }

    @GetMapping({"", "/listar"})
    public String listarVentas() {
        List<Venta> lista = ventaService.obtenerVentas();
        return gson.toJson(lista);
    }

    @PostMapping
    public String insertar(@RequestBody Venta v) {
        boolean ok = ventaService.agregarVenta(v);
        return "{\"success\": " + ok + "}";
    }

    @PutMapping("/{id}")
    public String actualizar(@PathVariable int id, @RequestBody Venta v) {
        v.setId(id);
        boolean ok = ventaService.actualizarVenta(v);
        return "{\"success\": " + ok + "}";
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        boolean ok = ventaService.eliminarVenta(id);
        return "{\"success\": " + ok + "}";
    }
}