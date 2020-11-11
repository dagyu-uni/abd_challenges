package it.unimi.di.abd;

import java.io.File;

public class App {
    public static void main(String[] args)  {
        SQLAdapter sourceAdapter = new SQLAdapter();
        FSAdapter targetAdapter = new FSAdapter("/tmp/cdc");
        File syncFileDir = new File("/tmp/sync/");
        CDC cdc = new CDC(sourceAdapter, targetAdapter, syncFileDir);
        cdc.run();
    }
}
