package br.com.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

public class Arquivo {

    
    public static final String PREFIX = "stream2file";
    public static final String SUFFIX = ".tmp";
    private String DIRETORIO_TEMP = "//tmp//";

    public File criar(String xPath) throws RuntimeException {
        File bpaBaseDir = new File(DIRETORIO_TEMP);
        if (!bpaBaseDir.exists()) {
            boolean mkdir = bpaBaseDir.mkdir();
            if (!mkdir) {
                throw new RuntimeException("Impossível criar o diretório base.");
            }
        }
        File file = new File(DIRETORIO_TEMP, xPath);
        return file;
    }

    public File ler(String xPath) throws RuntimeException {
        File file = new File(DIRETORIO_TEMP, xPath);
        return file;
    }

    //Convert InputStream to virtual File
    public static File criarArquivoTemporario(InputStream in) throws IOException {
        final File tempFile = File.createTempFile(PREFIX, SUFFIX);
        tempFile.deleteOnExit();
        FileOutputStream out = new FileOutputStream(tempFile);
        IOUtils.copy(in, out);
        return tempFile;
    }
}
