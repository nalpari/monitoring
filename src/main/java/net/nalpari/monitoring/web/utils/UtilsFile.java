package net.nalpari.monitoring.web.utils;

import net.nalpari.monitoring.config.exception.FilePathException;

public class UtilsFile {
    public static String validateFilePath(String filePath) throws Exception {
        String result = "";
        if (filePath.startsWith("/data/cdn")) {
            result = filePath;
        } else {
            throw new FilePathException();
        }

        return result;
    }
}
