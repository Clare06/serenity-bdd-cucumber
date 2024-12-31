pipeline {
    agent any
    environment {
        SERENITY_CREDS = credentials('serenity-credentials-for-uom-login')
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
                    def envContent = """
                    UOMUSER=${SERENITY_CREDS_USR}
                    PASSWORD=${SERENITY_CREDS_PSW}
                    """
                    writeFile file: '.env', text: envContent
                }
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
            publishHTML (target : [allowMissing: false,
             alwaysLinkToLastBuild: true,
             keepAll: true,
             reportDir: 'target/site/serenity',
             reportFiles: 'index.html',
             reportName: 'Serenity Report',
             reportTitles: 'The Test Report'])
        }
    }
}
