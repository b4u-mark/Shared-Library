package com.mcnz
import groovy.io.FileType

public class FileTest {

  def buildrelease() {
    def fileList = []
    def file = new File("your_repo_dir")
    file.eachFileRecurse (FileType.FILES) { rel_file ->
    fileList << rel_file
    }
    if (rel_file.exists()){
      return true;
    }
    else {
      println "File does not exist."
    }
    
    return false;
  }

}