package com.mcnz

public class File_Test {

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
