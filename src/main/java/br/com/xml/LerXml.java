package br.com.xml;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXB;

public class LerXml {

    public static void main(String[] args) {
        File ler = new Arquivo().ler("arquivo.xml");
     // File ler = lerArquivo();
        Registro evento = JAXB.unmarshal(ler, Registro.class);
        System.out.println(evento.getTitulo());
        System.out.println(evento.getData());
    }

    private static File lerArquivo() {
        try {
            StringBuilder xml = new StringBuilder();
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
            xml.append("<registro>");
            xml.append("    <data>03/05/2014</data>");
            xml.append("    <titulo>Campus Party</titulo>");
            xml.append("</registro>");
            InputStream inputStream = new ByteArrayInputStream(xml.toString().getBytes());
            File file = Arquivo.criarArquivoTemporario(inputStream);
            return file;
        } catch (Exception ex) {
            Logger.getLogger(LerXml.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
