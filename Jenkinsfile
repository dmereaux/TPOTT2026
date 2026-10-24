pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/dmereaux/TPOTT2026.git'

                // Run the build on a Unix agent. You must have Maven installed.
                sh 'mvn -Dmaven.test.failure.ignore=true clean install'

                // To run Maven on a Windows agent, use
                // bat 'mvn -Dmaven.test.failure.ignore=true clean package'
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.war'
                }
            }
        }
        stage('deploy on docker test env') {
            steps {
                // Get some code from a GitHub repository
                sh 'docker build -t tpott .'
           }

        }
        stage('launch web application') {
            steps {
                // Get some code from a GitHub repository
               sh 'docker run -d -p 8080:8080 --name tpottc tpott'
               echo "totou"
           }
        post {
            always {

                // Clean up
                echo "lancer"
             //   sh 'docker stop tpottc && docker rm tpottc'
          
              }
           }
        }
    }

}
