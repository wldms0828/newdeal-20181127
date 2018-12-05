package com.eomcs.lms.handler;

import java.util.Scanner;

public class HelloCommand implements Command {
  
  Scanner keyboard;
  

  public HelloCommand(Scanner keyboard) {
    keyboard=keyboard;
}
  public void execute() {
    System.out.println("이름은?");
    String name = keyboard.nextLine();
    
  }
}
