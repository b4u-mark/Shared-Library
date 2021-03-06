#!/usr/bin/env groovy

// Jenkinsfile (Declarative Pipeline)
pipeline {
  agent any
  stages {
    stage('Checkout Input') {
      steps {
        echo 'Hello world!'
      }
    stage('Analyze & Report') {
      steps {
        echo 'Hello All!'
      }
    stage('Email Notification') {
      steps {
        emailext body: '''Hello Your email has configured successfully!!!''', subject: 'Hi This is for email configuration in jenkins', to: 'b4u.mark@gmail.com'
      }
    }
  }