package br.com.xml;

import java.io.File;
import java.util.Date;
import javax.xml.bind.JAXB;

public class GerarXml {

    public static void main(String[] args) {
        File file = new Arquivo().criar("arquivo.xml");
        Registro campus = new Registro();
        campus.setTitulo("Titulo");
        campus.setData(new Date());
        JAXB.marshal(campus, file);
    }
}
