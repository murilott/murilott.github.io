package br.univille.log;

public class LoggerConsole implements Logger {
  public String reset = "\u001B[0m";
  String col;
  
  @Override
  public void log(Level level, String message) {
    switch(level) {
      case WARNING:
        col = "\u001B[33m";

        break;
      case DEBUG:
        col = "\u001B[32m";

        break;
      case ERROR:
        col = "\u001B[31m";

        break;
    }
    System.out.println(col + level + ": " + message + reset);
  }
}