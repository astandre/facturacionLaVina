/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Categoria {
   private int cod_categoria;
   private String nombre_categoria;
   private ArrayList<Productos> lst_productos;

    public Categoria(int cod_categoria, String nombre_categoria, ArrayList<Productos> lst_productos) {
        this.cod_categoria = cod_categoria;
        this.nombre_categoria = nombre_categoria;
        this.lst_productos = lst_productos;
    }
      /**
     * @return the cod_categoria
     */
    public int getCod_categoria() {
        return cod_categoria;
    }

    /**
     * @param cod_categoria the cod_categoria to set
     */
    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    /**
     * @return the nombre_categoria
     */
    public String getNombre_categoria() {
        return nombre_categoria;
    }

    /**
     * @param nombre_categoria the nombre_categoria to set
     */
    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    /**
     * @return the lst_productos
     */
    public ArrayList<Productos> getLst_productos() {
        return lst_productos;
    }

    /**
     * @param lst_productos the lst_productos to set
     */
    public void setLst_productos(ArrayList<Productos> lst_productos) {
        this.lst_productos = lst_productos;
    }
   
}
