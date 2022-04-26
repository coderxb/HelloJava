package com.china.gavin.javabase.file;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class TempFileExample {

    private static final Logger log = Logger.getLogger(TempFileExample.class.getName());

    public static void main(String[] args) {
        createTempFile();
    }

    private static void createTempFile() {
        try {
            File tempFile = File.createTempFile("tmp", ".jpg");
            tempFile.deleteOnExit();
            log.info("temp file name = " + tempFile.getName());
            log.info(String.format("temp file getAbsolutePath = %s", tempFile.getAbsolutePath()));
            log.info(String.format("temp file getPath = %s", tempFile.getPath()));
            log.info(String.format("temp file getCanonicalPath = %s", tempFile.getCanonicalPath()));
            log.info(String.format("temp file getParent = %s", tempFile.getParent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
