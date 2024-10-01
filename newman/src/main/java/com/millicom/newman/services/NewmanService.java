package com.millicom.newman.services;


import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class NewmanService {

	
	public String runNewmanCommand(String collectionPath,String reportPath,Integer iteraciones) throws IOException, InterruptedException {
        // Comando newman
        //String command = "newman run " + collectionPath + " -r htmlextra --reporter-htmlextra-export " + reportPath + " -n "+ iteraciones;
        String command = "sudo newman run " + collectionPath + " -r htmlextra --reporter-htmlextra-export " + reportPath + " -n "+ iteraciones;

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("sh", "-c", command);
        //processBuilder.command("cmd.exe", "/c", command);

        try {
            Process process = processBuilder.start();

            // Leer la salida del comando
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Leer errores del comando
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }

            int exitCode = process.waitFor();
            //if (exitCode != 0) {
            //    throw new RuntimeException("Command failed with exit code " + exitCode);
            //}
            return "Comando ejecutado";

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
	
}
