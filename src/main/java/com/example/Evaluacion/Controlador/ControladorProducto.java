package com.example.Evaluacion.Controlador;

import com.example.Evaluacion.Entidad.Producto;
import com.example.Evaluacion.Servicio.ServicioProducto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControladorProducto {
    ServicioProducto sp = new ServicioProducto();

    @GetMapping("/listar")
    public ArrayList<Producto> listar() {
        return sp.productos();
    }

    @GetMapping("/buscar-codigo/{cod}")
    public ArrayList<Producto> codigo(@PathVariable("cod") int codigo) {
        return sp.codigo(codigo);
    }

    @GetMapping("/categoria/{cat}")
    public ArrayList<Producto> categorias(@PathVariable("cat")String categoria) {
        return sp.buscar(categoria);
    }

    @PutMapping("/actualizar-producto/{cod}")
    public Producto actualizar(@PathVariable("cod") int Codigo, @RequestBody Producto p) {
        System.out.println(p);
        return sp.actualizar(p, Codigo);
    }

    @PutMapping("/actualizar-descuento/{cat}")
    public ArrayList<Producto> descuento(@PathVariable("cat") String categoria){
        return sp.descuento(categoria);
    }
}
