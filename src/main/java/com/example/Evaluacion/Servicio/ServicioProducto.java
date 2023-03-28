package com.example.Evaluacion.Servicio;

import com.example.Evaluacion.Entidad.Producto;

import java.util.ArrayList;

public class ServicioProducto {
    ArrayList<Producto> lista = new ArrayList<>();
    ArrayList<Producto> mostrar = new ArrayList<>();
    ArrayList<Producto> descuentos = new ArrayList<>();
    public ServicioProducto() {
        lista.add(new Producto(1, "Papa", "vegetales", 600, 100));
        lista.add(new Producto(2, "Pera", "frutas", 500, 124));
        lista.add(new Producto(3, "Bonyurt", "frutas", 2300, 64));
        lista.add(new Producto(4, "Calabaza", "vegetales", 2000, 90));
        lista.add(new Producto(5, "Escoba", "aseo", 4500, 90));
        lista.add(new Producto(6, "Rabano", "vegetales", 4000, 90));
        lista.add(new Producto(7, "Zanahoria", "vegetales", 800, 90));
        lista.add(new Producto(8, "Cebolla", "vegetales", 900, 90));
        lista.add(new Producto(9, "Trapero", "aseo", 3000, 90));
        lista.add(new Producto(10, "Recojedor", "aseo", 3000, 90));
    }

    public ArrayList<Producto> productos() {
        return lista;
    }

    public ArrayList<Producto> buscar(String categoria) {
        mostrar.clear();
        for(Producto i: lista){
            if (i.getCategoria().equals(categoria)){
                mostrar.add(i);
            }
        }
        return mostrar;
    }

    public ArrayList<Producto> codigo(int codigo) {
        mostrar.clear();
        for(Producto i:lista){
            if(i.getCodigo() == codigo){
                mostrar.add(i);
            }
        }
        return mostrar;
    }

    public  Producto actualizar(Producto p, int Codigo) {
        Producto mostrar= null;
        for (Producto i : lista) {
            if (i.getCodigo() == Codigo) {
                lista.remove(i);
                lista.add(p);
                int total = p.getPrecio()*p.getCantidad();
                p.setTotal(total);
                int total_iva = ((p.getTotal()*19)/100)+p.getTotal();
                p.setTotal_iva(total_iva);
                mostrar = p;
                break;
            }
        }
        return mostrar;
    }

    public ArrayList<Producto> descuento(String categoria) {
        descuentos.clear();
        for(Producto i:buscar(categoria)){
            int descuento = i.getPrecio()-((i.getPrecio()*20)/100);
            i.setDescuento(descuento);
            descuentos.add(i);
        }
        return descuentos;
    }
}
