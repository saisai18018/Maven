pipeline {
   agent any

   environment {
       APP_ENV = 'dev'
   }

   stages {
       stage('Clone') {
            steps {
                echo 'Cloning repository...'
                git branch: 'main', url: 'https://github.com/saisai18018/Maven.git'
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
                junit '**/target/surefire-reports/*.xml'  // publish JUnit results
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
            echo 'Pipeline succeeded! Sending email...'
            mail to: 'saimomdad99@gmail.com',
                 subject: "Build Success: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Good news! The build passed.\nCheck it here: ${env.BUILD_URL}"
        }
        failure {
            echo 'Pipeline failed! Sending email...'
            mail to: 'saimomdad99@gmail.com',
                 subject: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Unfortunately, the build failed.\nCheck it here: ${env.BUILD_URL}"
        }
   }
}
