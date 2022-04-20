#!/usr/bin/env groovy

pipeline {
  agent any
  stages {
    stage('Checkout Input') {
      steps {
	  git branch: 'main',
        url: "https://github.com/b4u-mark/Shared-Library.git"
      }
    }
    stage('Analyze & Report') {
      steps {
               script {
			 def fh = readFile(file: 'Release_Status.csv')
                   println "The file has ${fh.length()} bytes"
			 def data = fh.toString()
			 println data
 	         }  
           } 
    }
    stage('Email Notification') {
      steps {
        emailext from: 'jenkinsmarkandrew@gmail.com', attachLog: true, body: "Hi, <p> Please find the attached log for details </p>", mimeType: 'text/html', subject: "Reg: Release Log", to: 'jenkinsmarkandrew@gmail.com'
      }
    }
  }
}