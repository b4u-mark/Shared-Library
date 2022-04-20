#!/usr/bin/env groovy

def git_branch = env.GIT_BRANCH
def git_url = env.GIT_URL
def git_file = env.FILE
def git_email = env.EmailID

pipeline {
  agent any
  stages {
    stage('Checkout Input') {
      steps {
        println git_branch
	  git branch: git_branch,
        url: git_url
      }
    }
    stage('Analyze & Report') {
      steps {
               script {
			 def fh = readFile(file: git_file)
                   println "The file has ${fh.length()} bytes"
			 def data = fh.toString()
			 println data
 	         }  
           } 
    }
    stage('Email Notification') {
      steps {
        emailext from: git_email, attachLog: true, body: "Hi, <p> Please find the attached log for details </p>", mimeType: 'text/html', subject: "Reg: Release Log", to: git_email
      }
    }
  }
}