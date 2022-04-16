package com.mcnz
import groovy.io.FileType

public class FileTest {

  def buildrelease() {
    def file = new File("Release_Status.csv")
    
    if (file.exists()){
      return true;
    }
    else {
      println "File does not exist."
    }
    
    return false;
  }

}