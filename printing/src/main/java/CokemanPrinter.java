import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.model.Resource;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

import static java.nio.file.FileSystems.*;

@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_RESOURCES)
public class CokemanPrinter extends AbstractMojo {

    @Parameter(alias = "expirationDate", required = false)
    private String expirationDate;

    @Parameter(alias = "destinationFolder", defaultValue = "${project.build.directory}/generated-resources/license")
    private File destinationFolder;

    @Parameter(defaultValue = "${project}")
    private MavenProject project;

    public void setProject(MavenProject project) {
        this.project = project;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setDestinationFolder(File destinationFolder) {
        this.destinationFolder = destinationFolder;
    }

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if (expirationDate != null) {
            Resource rs = new Resource();
            rs.setFiltering(false);
            String destFold = destinationFolder.getPath();
            rs.setDirectory(destFold);
            project.addResource(rs);
            String destFold1 = destinationFolder.getAbsolutePath();
            Path directoryPath = getDefault().getPath(destFold1);
            System.out.println("dsdsadsdf");
            try {
                Files.createDirectories(directoryPath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Path filePath = getDefault().getPath(destFold1, expirationDate);
            try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
                writer.write(expirationDate);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
