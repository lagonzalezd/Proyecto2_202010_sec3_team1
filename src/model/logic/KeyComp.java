package model.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KeyComp implements Comparable<KeyComp>{

    private int id;
    private Date fecha;
    private String clasevehiculo;
    private String infraccion;


    public KeyComp(int i,Date f,String cv,String in)
    {
        id=i;
        fecha=f;
        clasevehiculo=cv;
        infraccion=in;
    }




    public int hashCode()
    {
        int hash=17;
        hash=(31*hash)+fecha.hashCode();
        hash=(31*hash)+clasevehiculo.hashCode();
        hash=(31*hash)+infraccion.hashCode();
        return hash;

    }


    public int compareTo(KeyComp o) {
        int retorno=0;

        if(id>o.getId())
        {
            retorno=1;
        }
        else if(id<o.getId())
        {
            retorno=-1;
        }
        return retorno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getClasevehiculo() {
        return clasevehiculo;
    }

    public void setClasevehiculo(String clasevehiculo) {
        this.clasevehiculo = clasevehiculo;
    }

    public String getInfraccion() {
        return infraccion;
    }

    public void setInfraccion(String infraccion) {
        this.infraccion = infraccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}