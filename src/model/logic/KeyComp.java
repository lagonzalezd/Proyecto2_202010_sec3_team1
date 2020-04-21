package model.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KeyComp implements Comparable<KeyComp>{

    private int objectId;
    private Comparendo comp;


    public KeyComp(int pObjectId, Comparendo pComp)
    {
<<<<<<< HEAD
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
=======

        objectId = pObjectId;
        comp = pComp;
>>>>>>> ffd221e786c26bf32aec35aadc16022909e9c5ac

    }


    public int compareTo(KeyComp o) {
        int salida =0;

        if(objectId>o.getId())
        {
            salida =1;
        }
        else if(objectId<o.getId())
        {
            salida = -1;
        }
        return salida ;
    }



}