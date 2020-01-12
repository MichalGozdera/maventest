import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.logging.Logger;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTestDupa {

    Logger logger = Logger.getGlobal();

    @Test
    public void testReadLicense() throws Exception {
        File folder = new File("./target/generated-resources/license");
        if (folder == null ||folder.listFiles()==null) {
            logger.info("dupa license folder does not exists");
        } else if (folder.listFiles().length > 0) {
            File[] listOfFiles = folder.listFiles();
            logger.info(listOfFiles[0].getName());
            assertEquals("wafel", listOfFiles[0].getName());
        } else {
            logger.info("dupa license folder is empty");
        }

    }
}
