
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTestDupaTest {

    Logger logger = Logger.getGlobal();

    @Test
    public void testReadLicense() throws Exception {
        File folder = new File("./target/generated-resources/license");
        if (folder == null ||folder.listFiles()==null) {
            logger.info("dupa license folder does not exists");
        } else if (folder.listFiles().length > 0) {
            File[] listOfFiles = folder.listFiles();
            logger.info(listOfFiles[0].getName());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String expirationDateS = StringUtils.isEmpty(listOfFiles[0].getName()) ?
                    LocalDate.now().plusDays(14).format(formatter) :
                    listOfFiles[0].getName();
            logger.info(expirationDateS);
        } else {
            logger.info("dupa license folder is empty");
        }

    }
}
