package at.kaindorf.visitor;

import java.nio.file.Path;

/**
 * <h3>Created by IntelliJ IDEA.</h3><br>
 * <b>Project:</b> Exa_RP_FT_2022_Wetterdaten<br>
 * <b>User:</b> Simon SchÃ¶ggler<br>
 * <b>Date:</b> 22. April 2023<br>
 * <b>Time:</b> 10:30 AM<br>
 */

public interface IDirectoryVisitor {
    void enterDirectory (Path dir);
    void leaveDirectory (Path dir);
    void visitFile (Path file);
}
