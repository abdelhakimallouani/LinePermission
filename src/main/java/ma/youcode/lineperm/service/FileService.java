package ma.youcode.lineperm.service;

import ma.youcode.lineperm.enums.Permission;
import ma.youcode.lineperm.model.LinFile;

import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {

        private static final Path FILES_DIRECTORY = Path.of("data/files");

        public FileService() {
            try {
                if (!Files.exists(FILES_DIRECTORY)) {
                    Files.createDirectories(FILES_DIRECTORY);
                }
            } catch (Exception e) {
                System.out.println("Erreur de la creation " );
            }
        }

        public LinFile touch(String name, String owner) {

            try {
                Path filePath = FILES_DIRECTORY.resolve(name);

                if (Files.exists(filePath)) {
                    System.out.println("le fichie existe");
                    return null;
                    
                }

                Files.createFile(filePath);

                LinFile file = new LinFile(name, owner, Permission.Normale);
                return file;

                
            } catch (Exception e) {
                System.out.println("Erreur de la creation " );
                return null;
            }
        }
}
