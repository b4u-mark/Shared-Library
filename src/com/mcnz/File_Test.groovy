package com.mcnz
import groovy.io.FileType

public class FileTest {

  def buildrelease() {
    def file = new File("Release_Status.csv")
    println "Check file.exists()"
    
    if (file.exists()){
      return true;
      println "File exists"
    }
    else {
      println "File does not exist."
    }
    
    return false;
  }

}
