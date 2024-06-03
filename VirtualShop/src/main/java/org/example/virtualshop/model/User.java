package org.example.virtualshop.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    public String name;

    public String password;

    private static List<Product> listaProducts = new ArrayList<Product>();

    private static List<Buy> listaCompras = new ArrayList<Buy>();

    public User() {

    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Product> getListaProducts() {
        return listaProducts;
    }

    public void setListaProducts(List<Product> listaProducts) {
        User.listaProducts = listaProducts;
    }

    public List<Buy> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Buy> listaCompras) {
        User.listaCompras = listaCompras;
    }
}
