package com.millicom.newman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.millicom.newman.services.NewmanService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
public class NewmanController {

	@Autowired
	NewmanService newmanService;
	
	
	@GetMapping("/run-newman")
    public String  runNewman(@RequestParam String collectionPath, @RequestParam String reportPath,@RequestParam Integer iteraciones) throws IOException, InterruptedException {
		try {
			newmanService.runNewmanCommand(collectionPath,reportPath,iteraciones);
            return "Newman command executed successfully.";
        } catch (IOException | InterruptedException e) {
            return "Error executing newman command: " + e.getMessage();
        }
    }
	
	
	@GetMapping("/run-newman/dato")
    public String runNewmanGet()  {
        ProcessBuilder processBuilder = new ProcessBuilder();
     
        try {
            
                return "TRY Newman executed successfully. Report generated at: ";
            
        } catch (Exception e) {
            e.printStackTrace();
            return "CATCH Newman executed successfully. Report generated at: ";
        }
    }
	
	
}
