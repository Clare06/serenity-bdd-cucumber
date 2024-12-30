pipeline {
    agent any
    environment {
        ENV_FILE = '.env' // Define the .env file name
    }
    stages {
        stage('Clone Repository') {
            steps {
                // Clone the repository
                checkout scm
            }
        }
        stage('Setup Environment') {
            steps {
                script {
                    // Fetch sensitive data using credentials
                    withCredentials([
                            usernamePassword(credentialsId: 'serenity-credentials-for-uom-login', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')
                    ]) {
                        def envContent = """
                        USER=${USERNAME}
                        PASSWORD=${PASSWORD}
                        """
                        writeFile file: ENV_FILE, text: envContent // Write to .env file
                    }
                }
            }
        }
        stage('Run Serenity Tests') {
            steps {
                // Run Maven build
                sh 'cat .env' // Debugging: Print the .env file (remove in production)
                sh 'mvn clean verify' // Run Serenity tests
            }
        }
    }
    post {
        always {
            // Archive Serenity reports
            archiveArtifacts artifacts: '**/target/site/serenity/**', fingerprint: true
        }
    }
}

