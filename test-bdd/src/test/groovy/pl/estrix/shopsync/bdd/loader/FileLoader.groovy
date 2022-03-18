package pl.estrix.shopsync.bdd.loader


import org.apache.commons.io.IOUtils
import org.apache.commons.lang3.StringUtils

import java.nio.charset.StandardCharsets

class FileLoader {

    private static def REQUESTS_PATH = "/requests/"

    String loadRequestAsString(fileName) {
        InputStream resource = getClass().getResourceAsStream(String.join(StringUtils.EMPTY, REQUESTS_PATH, fileName))
        return IOUtils.toString(resource, StandardCharsets.UTF_8)
    }
}
