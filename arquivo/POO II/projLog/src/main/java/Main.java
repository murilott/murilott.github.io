import java.nio.file.Files;

import br.univille.log.LoggerFactory;
import br.univille.log.Logger;
import br.univille.log.Level;
import br.univille.log.LoggerConsole;
import br.univille.log.LoggerFile;

public class Main {
  public static void main(String[] args) {
    System.out.println("Programa logs");

    LoggerFactory logFact = new LoggerFactory();

    Logger logConsole = logFact.onConsole();
    logConsole.log(Level.DEBUG, "Tudo certo");
    logConsole.log(Level.WARNING, "Indente seu código");
    logConsole.log(Level.ERROR, "Faltou ponto e vírgula");

    Logger logFile = logFact.onFile();
    logFile.log(Level.DEBUG, "Iniciado");
    logFile.log(Level.DEBUG, "Level iniciado");
    logFile.log(Level.ERROR, "Arquivo shader.2d não encontrado");
  }
}