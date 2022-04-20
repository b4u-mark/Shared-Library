#!/usr/bin/env groovy

pipeline {
  agent any
  stages {
    stage('Checkout Input') {
      steps {
	  git branch: $GIT_BRANCH,
        url: $GIT_URL
      }
    }
    stage('Analyze & Report') {
      steps {
               script {
			 def fh = readFile(file: $FILE)
                   println "The file has ${fh.length()} bytes"
			 def data = fh.toString()
			 println data
 	         }  
           } 
    }
    stage('Email Notification') {
      steps {
        emailext from: $EmailID, attachLog: true, body: "Hi, <p> Please find the attached log for details </p>", mimeType: 'text/html', subject: "Reg: Release Log", to: $EmailID
      }
    }
  }
}