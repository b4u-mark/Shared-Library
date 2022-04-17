#!/usr/bin/env groovy

@Grab('com.xlson.groovycsv:groovycsv:1.3')
import static com.xlson.groovycsv.CsvParser.parseCsv

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
        script {
			 fh = new File('Release_Status.csv')
                   def csv_content = fh.getText('utf-8')

			 def data1 = parseCsv(csv_content, separator: ';', readFirstLine: true)
			 // println data_iterator.getClass()  // class com.xlson.groovycsv.CsvIterator

                   def data1 = new CsvParser().parse(csv)
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