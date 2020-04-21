package model.logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KeyComp implements Comparable<KeyComp>{

    private int objectId;
    private Comparendo comp;


    public KeyComp(int pObjectId, Comparendo pComp)
    {

        objectId = pObjectId;
        comp = pComp;

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