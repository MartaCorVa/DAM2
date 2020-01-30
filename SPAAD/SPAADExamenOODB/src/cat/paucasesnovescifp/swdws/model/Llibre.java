/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.paucasesnovescifp.swdws.model;

import java.util.Objects;

/**
 *
 * @author alumne
 */
public class Llibre {

    private int idLlib;
    private String titol;
    private String numeroEdicio;
    private String llocEdicio;
    private int anyEdicio;
    private String descripcioLlibre;
    private String isbn;
    private String depositLegal;
    private String signTop;
    private Autor autor;

    public Llibre(int idLlib, String titol, String llocEdicio, String numeroEdicio, int anyEdicio, String descripcioLlibre, String isbn, String depositLegal, String signTop, Autor autor) {
        this.idLlib = idLlib;
        this.titol = titol;
        this.numeroEdicio = numeroEdicio;
        this.llocEdicio = llocEdicio;
        this.anyEdicio = anyEdicio;
        this.descripcioLlibre = descripcioLlibre;
        this.isbn = isbn;
        this.depositLegal = depositLegal;
        this.signTop = signTop;
        this.autor = autor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    
    public int getIdLlib() {
        return idLlib;
    }

    public void setIdLlib(int idLlib) {
        this.idLlib = idLlib;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getNumeroEdicio() {
        return numeroEdicio;
    }

    public void setNumeroEdicio(String numeroEdicio) {
        this.numeroEdicio = numeroEdicio;
    }

    public String getLlocEdicio() {
        return llocEdicio;
    }

    public void setLlocEdicio(String llocEdicio) {
        this.llocEdicio = llocEdicio;
    }

    public int getAnyEdicio() {
        return anyEdicio;
    }

    public void setAnyEdicio(int anyEdicio) {
        this.anyEdicio = anyEdicio;
    }

    public String getDescripcioLlibre() {
        return descripcioLlibre;
    }

    public void setDescripcioLlibre(String descripcioLlibre) {
        this.descripcioLlibre = descripcioLlibre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDepositLegal() {
        return depositLegal;
    }

    public void setDepositLegal(String depositLegal) {
        this.depositLegal = depositLegal;
    }

    public String getSignTop() {
        return signTop;
    }

    public void setSignTop(String signTop) {
        this.signTop = signTop;
    }

    @Override
    public String toString() {
        return "Llibre{" +
                "idLlib=" + idLlib +
                ", titol='" + titol + '\'' +
                ", numeroEdicio='" + numeroEdicio + '\'' +
                ", llocEdicio='" + llocEdicio + '\'' +
                ", anyEdicio=" + anyEdicio +
                ", descripcioLlibre='" + descripcioLlibre + '\'' +
                ", isbn='" + isbn + '\'' +
                ", depositLegal='" + depositLegal + '\'' +
                ", signTop='" + signTop + '\'' +
                ", autor=" + autor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Llibre llibre = (Llibre) o;
        return idLlib == llibre.idLlib &&
                anyEdicio == llibre.anyEdicio &&
                Objects.equals(titol, llibre.titol) &&
                Objects.equals(numeroEdicio, llibre.numeroEdicio) &&
                Objects.equals(llocEdicio, llibre.llocEdicio) &&
                Objects.equals(descripcioLlibre, llibre.descripcioLlibre) &&
                Objects.equals(isbn, llibre.isbn) &&
                Objects.equals(depositLegal, llibre.depositLegal) &&
                Objects.equals(signTop, llibre.signTop) &&
                Objects.equals(autor, llibre.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLlib, titol, numeroEdicio, llocEdicio, anyEdicio, descripcioLlibre, isbn, depositLegal, signTop, autor);
    }
}
