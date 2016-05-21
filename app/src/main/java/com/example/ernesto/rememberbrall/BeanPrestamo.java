package com.example.ernesto.rememberbrall;

/**
 * Created by edgar on 21/05/16.
 */

import java.util.Date;



        import java.util.Date;

/**
 * Created by edgar on 21/05/16.
 */
public class BeanPrestamo {

    public String NombrePersona;
    public String NombreObjeto;
    public String DescripcionObjeto;
    public String FechaD;
    public String Status;
    public BeanPrestamo(){

    }
    public String getNombrePersona(){
        return NombrePersona;
    }
    public String getNombreObjeto(){
        return NombreObjeto;
    }
    public String getDescripcionObjeto(){
        return DescripcionObjeto;
    }
    public String getStatus(){
        return Status;
    }
    public String getFechaD(){
        return FechaD;
    }
    public void setNombrePersona( String NombrePersona){
        this.NombrePersona=NombrePersona;
    }
    public void setNombreObjeto( String NombreObjeto){
        this.NombreObjeto=NombreObjeto;
    }
    public void setDescripcionObjeto( String DescripcionObjeto){
        this.DescripcionObjeto=DescripcionObjeto;
    }
    public void setFechaD( String FechaD){
        this.FechaD=FechaD;
    }
    public void setStatus( String Status){
        this.Status=Status;
    }

    public BeanPrestamo(String NombrePersona, String NombreObjeto, String DescripcionObjeto, String FechaD, String Status){
        super();
        this.NombrePersona=NombrePersona;
        this.NombreObjeto=NombreObjeto;
        this.DescripcionObjeto=DescripcionObjeto;
        this.FechaD=FechaD;
        this.Status=Status;
    }
}