package com.example.run;

import com.example.config.ConfigLoader;
import com.example.config.Configuration;
import com.example.machine.TuringMachine;
import com.example.machine.TuringMachineBuilder;

import java.util.Scanner;

public class CLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Turing Machine Simulator!");
        System.out.println("Enter the path to your configuration file (e.g., config.json):");
        String filePath = "D:\\TuringMachine\\ca-project-work\\src\\main\\java\\com\\example\\config\\json\\palindrom.json";

        try {
            //config load
            Configuration config = ConfigLoader.loadConfig(filePath);
            TuringMachine machine = TuringMachineBuilder.buildFromConfig(config);

            // initial tape output
            System.out.println("Initial Tape: " + config.getTape());

            // executing
            System.out.println("Executing the Turing Machine...");
            machine.execute();

            // final tape output
            System.out.println("Final Tape: " + machine.getTape());
        } catch (Exception e) {
            System.out.println("Error loading or executing the Turing Machine: " + e.getMessage());
        }
    }

}

