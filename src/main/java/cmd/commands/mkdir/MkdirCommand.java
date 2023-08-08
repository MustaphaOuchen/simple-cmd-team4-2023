package cmd.commands.mkdir;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cmd.SimpleCmd;
import cmd.commands.dir.DirCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@CommandLine.Command(
        name = "mkdir",
        description = "Create new directory or file",
        mixinStandardHelpOptions = true)
public class MkdirCommand implements Runnable{

    private static final Logger LOG = LoggerFactory.getLogger(DirCommand.class);


    @CommandLine.Parameters(index = "0", description = "Absolute path of the new directory")
    private File targetDirectoryOrFile;

    @CommandLine.Parameters(index = "1", description = "Check if target is a file")
    private Boolean isFile;

    @Override
    public void run() {
        LOG.info("mkdir run method called");
        if(isFile){
            LOG.info("Creating a file");
            try {
                Files.createFile(targetDirectoryOrFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            LOG.info("Creating a directory");
            try {
                Files.createDirectory(targetDirectoryOrFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
