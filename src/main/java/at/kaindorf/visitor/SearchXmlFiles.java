package at.kaindorf.visitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;


/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Exa_RP_FT_2022_Wetterdaten<br>
 * <b>User:</b> Simon SchÃ¶ggler<br>
 * <b>Date:</b> 22. April 2023<br>
 * <b>Time:</b> 10:34 AM<br>
 */

public class SearchXmlFiles {
    private int directories;
    private int files;

    private Path workingDirectory;

    public SearchXmlFiles (Path workingDirectory) {
        this.workingDirectory = workingDirectory;
        DirectorySizeVisitor visitor = new DirectorySizeVisitor();
        traverse(workingDirectory, visitor);

        this.directories = visitor.getDirs();
        this.files = visitor.getXmlFiles();

    }

    public List<Path> getXmlFiles (Path workingDirectory) {
        DirectoryPrintVisitor visitor = new DirectoryPrintVisitor();
        traverse(workingDirectory, visitor);
        return visitor.getXmlFiles();
    }

    private void traverse (Path dir, IDirectoryVisitor visitor) {
        try {
            Files.walkFileTree(dir, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    visitor.enterDirectory(dir);
                    return super.preVisitDirectory(dir, attrs);
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    visitor.visitFile(file);
                    return super.visitFile(file, attrs);
                }
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    visitor.leaveDirectory(dir);
                    return super.postVisitDirectory(dir, exc);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getDirectories () {
        return directories;
    }

    public int getFiles() {
        return files;
    }
}
