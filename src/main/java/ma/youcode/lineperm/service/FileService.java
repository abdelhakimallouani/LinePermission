package ma.youcode.lineperm.service;

import ma.youcode.lineperm.enums.Permission;
import ma.youcode.lineperm.model.LinFile;

import java.util.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileService {

    private static final Path FILES_DIRECTORY = Path.of("data/files");
    private static final Path FILE_FILES = Path.of("data/files.txt");

    public FileService() {
        try {
            if (!Files.exists(FILES_DIRECTORY)) {
                Files.createDirectories(FILES_DIRECTORY);
            }
        } catch (Exception e) {
            System.out.println("Erreur de la creation ");
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

            String fileWrite = "rwd|" + Permission.Normale.getValue() + " " + owner + " " + name;

            Files.writeString(FILE_FILES, fileWrite + System.lineSeparator(), StandardOpenOption.APPEND);

            return file;

        } catch (Exception e) {
            System.out.println("Erreur de la creation ");
            return null;
        }
    }

    public void ls() {
        try {

            String content = Files.readString(FILE_FILES);

            System.out.println(content);

        } catch (Exception e) {
            System.out.println("u dont have files" + e.getMessage());
        }
    }

    public void cat(String fileName, String owner) {
        try {

            Path filePath = Path.of("data/files/" + fileName);

            LinFile file = UserService.filesMap.get(fileName);

            // if (!Files.exists(filePath)) {
            // System.out.println("You don't have this file");
            // return;
            // }

            // if (file == null) {
            //     System.out.println("File not found");
            //     return;
            // }

            Permission permission = file.getPermission();

            if (!file.getOwner().equals(owner)) {

                if (!permission.getValue().contains("r")) {
                    System.out.println("u dont have permission");
                    return;
                }
            }

            String content = Files.readString(filePath);

            if (content.isEmpty()) {
                System.out.println("ur file is vide");
            }

            System.out.println(content);

        } catch (Exception e) {
            System.out.println("u dont have files" + e.getMessage());
        }
    }

    public void nano() {
    }
}
