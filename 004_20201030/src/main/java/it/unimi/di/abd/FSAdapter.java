package it.unimi.di.abd;

import it.unimi.di.abd.adapter.TargetAdapter;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FSAdapter implements TargetAdapter {
    private File baseDir;

    public FSAdapter(String baseDirName) {
        this.baseDir = new File(baseDirName);
        this.baseDir.mkdir();
    }

    @Override
    public  File createFile(String name) {
        File file = new File(baseDir,name);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    @Override
    public File renameFile(String oldName, String newName) {
        File newFile = new File(baseDir, newName);
        new File(baseDir, oldName).renameTo(newFile);
        return newFile;
    }

    @Override
    public void removeAllFilesEndingWith(String ext) {
        Arrays.stream(baseDir.listFiles())
                .filter(e -> e.getName().endsWith(ext))
                .forEach(File::delete);
    }

}
