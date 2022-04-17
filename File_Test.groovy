#!/usr/bin/env groovy

@Grab('com.xlson.groovycsv:groovycsv:0.2')
import com.xlson.groovycsv.CsvParser

// Jenkinsfile (Declarative Pipeline)
pipeline {
  agent any
  stages {
    stage('Checkout Input') {
      steps {
        echo 'Hello world!'
      }
    }
    stage('Analyze & Report') {
      steps {
                   echo 'Check 1'
			 fh = new File('Release_Status.csv')
            	 echo 'Check 2'
                   def csv_content = fh.getText('utf-8') 
			 echo 'Check 3'                  

			 def data1 = parseCsv(csv_content, separator: ';', readFirstLine: true)
                   
				for(line in data1) {
                        println "$line.Name $line.Lastname"
		}
      } 
    }
    stage("Email Notification") {
      steps {
        emailext body: '''Hello Your email has configured successfully!!!''', subject: 'Hi This is for email configuration in jenkins', to: 'b4u.mark@gmail.com'
      }
    }
  }
}