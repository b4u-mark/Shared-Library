package com.mcnz

public class FileTest {

  def buildrelease() {
    def file = new File("D:/Release_Status.csv")
    
    if (file.exists()){
      return true;
    }
    else {
      println "File does not exist."
    }
    
    return false;
  }

}