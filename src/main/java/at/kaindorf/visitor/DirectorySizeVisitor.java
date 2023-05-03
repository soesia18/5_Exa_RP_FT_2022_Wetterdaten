package at.kaindorf.visitor;

import lombok.Getter;

import java.nio.file.Path;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Exa_RP_FT_2022_Wetterdaten<br>
 * <b>User:</b> Simon SchÃ¶ggler<br>
 * <b>Date:</b> 22. April 2023<br>
 * <b>Time:</b> 10:31 AM<br>
 */

@Getter
public class DirectorySizeVisitor implements IDirectoryVisitor {

    private int xmlFiles = 0;
    private int dirs = 0;

    @Override
    public void enterDirectory(Path dir) {
        dirs++;
    }

    @Override
    public void leaveDirectory(Path dir) {

    }

    @Override
    public void visitFile(Path file) {
        if (file.getFileName().toString().endsWith("xml")) {
            xmlFiles++;
        }
    }
}
