pipeline {
   agent any

   environment {
       APP_ENV = 'dev'
   }

   stages {
       stage('Clone') {
           steps {
               git 'https://github.com/saisai18018/Maven.git'
           }
       }
       stage('Build') {
           steps {
               echo 'Building the project...'
               bat 'mvn clean install'
           }
       }
       stage('Test') {
           steps {
               echo 'Running tests...'
               bat 'mvn test'
           }
       }
       stage('Run App') {
           steps {
               echo 'Running the Java App...'
               bat 'java -cp target/mavenproject-1.0-SNAPSHOT.jar com.example.App'
           }
       }
       stage('Deploy') {
           steps {
               echo "Deploying to ${env.APP_ENV} environment..."
           }
       }
   }

   post {
       success {
           echo 'Pipeline completed successfully.'
       }
       failure {
           echo 'Pipeline failed.'
       }
   }
}
