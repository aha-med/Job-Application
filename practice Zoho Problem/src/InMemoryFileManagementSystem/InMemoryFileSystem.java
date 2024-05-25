package InMemoryFileManagementSystem;

import java.util.*;

class FileNode {
    String name;
    String content;
    boolean isDeleted;

    public FileNode(String name) {
        this.name = name;
        this.content = "";
        this.isDeleted = false;
    }
}

class DirectoryNode {
    String name;
    boolean isDeleted;
    Map<String, DirectoryNode> subDirectories;
    Map<String, FileNode> files;

    public DirectoryNode(String name) {
        this.name = name;
        this.isDeleted = false;
        this.subDirectories = new HashMap<>();
        this.files = new HashMap<>();
    }
}

public class InMemoryFileSystem {
    private DirectoryNode root;
    private Map<String, DirectoryNode> deletedDirectories;
    private Map<String, FileNode> deletedFiles;

    public InMemoryFileSystem() {
        this.root = new DirectoryNode("/");
        this.deletedDirectories = new HashMap<>();
        this.deletedFiles = new HashMap<>();
    }

    // Module 1: Create a new directory or file
    public void create(String path, boolean isDirectory) {
        String[] parts = path.split("/");
        DirectoryNode current = root;

        for (int i = 1; i < parts.length - 1; i++) {
            if (!current.subDirectories.containsKey(parts[i])) {
                current.subDirectories.put(parts[i], new DirectoryNode(parts[i]));
            }
            current = current.subDirectories.get(parts[i]);
        }

        String name = parts[parts.length - 1];
        if (isDirectory) {
            current.subDirectories.put(name, new DirectoryNode(name));
        } else {
            current.files.put(name, new FileNode(name));
        }
    }

    // Module 2: List all directories and files
    public void list(String path) {
        DirectoryNode dir = getDirectory(path);
        if (dir != null) {
            for (String subDir : dir.subDirectories.keySet()) {
                System.out.println("Directory: " + subDir);
            }
            for (String file : dir.files.keySet()) {
                System.out.println("File: " + file);
            }
        } else {
            System.out.println("Directory not found");
        }
    }

    // Module 3: Update file content
    public void updateFileContent(String path, String content) {
        FileNode file = getFile(path);
        if (file != null) {
            file.content = content;
        } else {
            System.out.println("File not found");
        }
    }

    // Module 4: Update directory and file names
    public void updateName(String path, String newName) {
        String[] parts = path.split("/");
        DirectoryNode current = root;

        for (int i = 1; i < parts.length - 1; i++) {
            current = current.subDirectories.get(parts[i]);
        }

        String oldName = parts[parts.length - 1];
        if (current.files.containsKey(oldName)) {
            FileNode file = current.files.remove(oldName);
            file.name = newName;
            current.files.put(newName, file);
        } else if (current.subDirectories.containsKey(oldName)) {
            DirectoryNode dir = current.subDirectories.remove(oldName);
            dir.name = newName;
            current.subDirectories.put(newName, dir);
        } else {
            System.out.println("File or Directory not found");
        }
    }

    // Module 5: Delete directory and file
    public void delete(String path) {
        String[] parts = path.split("/");
        DirectoryNode current = root;

        for (int i = 1; i < parts.length - 1; i++) {
            current = current.subDirectories.get(parts[i]);
        }

        String name = parts[parts.length - 1];
        if (current.files.containsKey(name)) {
            FileNode file = current.files.remove(name);
            file.isDeleted = true;
            deletedFiles.put(path, file);
        } else if (current.subDirectories.containsKey(name)) {
            DirectoryNode dir = current.subDirectories.remove(name);
            dir.isDeleted = true;
            deletedDirectories.put(path, dir);
        } else {
            System.out.println("File or Directory not found");
        }
    }

    // Module 6: Restore deleted directories and files
    public void restore(String path) {
        if (deletedFiles.containsKey(path)) {
            FileNode file = deletedFiles.remove(path);
            file.isDeleted = false;

            String[] parts = path.split("/");
            DirectoryNode current = root;
            for (int i = 1; i < parts.length - 1; i++) {
                current = current.subDirectories.get(parts[i]);
            }
            current.files.put(parts[parts.length - 1], file);
        } else if (deletedDirectories.containsKey(path)) {
            DirectoryNode dir = deletedDirectories.remove(path);
            dir.isDeleted = false;

            String[] parts = path.split("/");
            DirectoryNode current = root;
            for (int i = 1; i < parts.length - 1; i++) {
                current = current.subDirectories.get(parts[i]);
            }
            current.subDirectories.put(parts[parts.length - 1], dir);
        } else {
            System.out.println("No such file or directory found in deleted items");
        }
    }

    private DirectoryNode getDirectory(String path) {
        String[] parts = path.split("/");
        DirectoryNode current = root;

        for (int i = 1; i < parts.length; i++) {
            if (current.subDirectories.containsKey(parts[i])) {
                current = current.subDirectories.get(parts[i]);
            } else {
                return null;
            }
        }
        return current;
    }

    private FileNode getFile(String path) {
        String[] parts = path.split("/");
        DirectoryNode current = root;

        for (int i = 1; i < parts.length - 1; i++) {
            if (current.subDirectories.containsKey(parts[i])) {
                current = current.subDirectories.get(parts[i]);
            } else {
                return null;
            }
        }

        return current.files.get(parts[parts.length - 1]);
    }

    public static void main(String[] args) {
        InMemoryFileSystem fs = new InMemoryFileSystem();

        // Create directories and files
        fs.create("/home", true);
        fs.create("/home/user", true);
        fs.create("/home/user/file.txt", false);

        // List directories and files
        fs.list("/home");

        // Update file content
//        fs.updateFileContent("/home/user/file.txt", "Hello, World!");
//
//        // Update directory and file names
//        fs.updateName("/home/user/file.txt", "newfile.txt");
//
//        // Delete directory and file
//        fs.delete("/home/user/newfile.txt");
//
//        // Restore directory and file
//        fs.restore("/home/user/newfile.txt");
//
//        // List directories and files again to check changes
//        fs.list("/home/user");
    }
}

