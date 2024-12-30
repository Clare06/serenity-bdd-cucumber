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

        stage('Host Serenity Reports') {
            steps {
                script {
                    sh 'fuser -k 8081/tcp || true'

                    sh 'nohup python3 -m http.server 8081 --directory /var/lib/jenkins/workspace/Group04_Serenity_BDD_Cucumber_Build/target/site/serenity &'
                }
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
