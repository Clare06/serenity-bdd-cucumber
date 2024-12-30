pipeline {
    agent any
    environment {
        ENV_FILE = '.env'
    }
    stages {
        stage('Clone Repository') {
            steps {
                checkout scm
            }
        }
        stage('Setup Environment') {
            steps {
                script {
                    withCredentials([
                            usernamePassword(credentialsId: 'serenity-credentials-for-uom-login', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')
                    ]) {
                        def envContent = """
                        USER=${USERNAME}
                        PASSWORD=${PASSWORD}
                        """
                        writeFile file: ENV_FILE, text: envContent
                    }
                }
            }
        }
        stage('Verify Maven') {
                    steps {
                        sh 'cat .env'
                        sh 'mvn -v'
                    }
                }
        stage('Run Serenity Tests') {
            steps {
                sh 'mvn clean verify'
            }
        }
    }
post {
        always {
            publishHTML(target: [
                allowMissing: false,
                keepAll: true,
                reportDir: 'target/site/serenity',
                reportFiles: 'index.html',
                reportName: 'Serenity Report'
            ])
        }
    }
}

