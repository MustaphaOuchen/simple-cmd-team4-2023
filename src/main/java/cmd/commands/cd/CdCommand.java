package cmd.commands.cd;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cmd.SimpleCmd;
import cmd.commands.dir.DirCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;



@Command(
    name = "cd",
    description = "Change the current directory",
    mixinStandardHelpOptions = true)
public class CdCommand implements Runnable{

  private static final Logger LOG = LoggerFactory.getLogger(DirCommand.class);


  @CommandLine.Parameters(index = "0", description = "Absolute path of the new directory")
  private File targetDirection;

  @Override
  public void run() {
    LOG.info("CD run method called");
    if(targetDirection.isDirectory()) {
      SimpleCmd.setCurrentLocation(targetDirection);
    } else {
      LOG.warn("No directory passed in cd command! Command not executed!");
    }

  }
}
