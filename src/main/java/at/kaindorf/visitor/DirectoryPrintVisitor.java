package at.kaindorf.visitor;

import lombok.Getter;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Exa_RP_FT_2022_Wetterdaten<br>
 * <b>User:</b> Simon SchÃ¶ggler<br>
 * <b>Date:</b> 22. April 2023<br>
 * <b>Time:</b> 10:33 AM<br>
 */

@Getter
public class DirectoryPrintVisitor implements IDirectoryVisitor {
    private List<Path> xmlFiles = new ArrayList<>();
    @Override
    public void enterDirectory(Path dir) {

    }

    @Override
    public void leaveDirectory(Path dir) {

    }

    @Override
    public void visitFile(Path file) {
        if (file.toString().endsWith("xml")) {
            xmlFiles.add(file);
        }
    }
}
