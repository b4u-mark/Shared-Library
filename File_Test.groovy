#!/usr/bin/env groovy

pipeline {
  agent any
  stages {
    stage('Checkout Input') {
      steps {
        echo 'Hello world!'
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
                   //def csv_content = fh.getText('utf-8') 
			 //println "Hello"                  

			 //def data1 = parseCsv(csv_content, separator: ';', readFirstLine: true)
                   
				//for(line in data1) {
                        //println "$line.Name $line.Lastname"
		            //}
 	             }  
           } 
    }
    stage("Email Notification") {
      steps {
        emailext body: '''Hello Your email has configured successfully!!!''', subject: 'Hi This is for email configuration in jenkins', to: 'markandrew_b4u@rediffmail.com'
      }
    }
  }
}