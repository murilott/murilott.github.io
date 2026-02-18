package br.univille.log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class LoggerFile implements Logger {

  @Override
  public void log(Level level, String message) {
    // escritas em um arquivo (EscreverArquivo)
    String filename = "logs.txt";
    String mensagem = level + ": " + message + "\n";
    
    try {
      if (Files.size(Paths.get(filename)) == 0) {
          Files.write(Paths.get(filename)
                     , mensagem.getBytes());
        }
      else {
          Files.write(Paths.get(filename)
                 , mensagem.getBytes()     
                 , StandardOpenOption.APPEND);
      }
    } catch (IOException e) {
        System.out.println("Erro ao salvar arquivo");
        e.printStackTrace();
    }
  }
}