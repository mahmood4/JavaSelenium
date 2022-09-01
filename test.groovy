pipeline {
    agent any
    tools{
        maven "MAVEN"
    }
    stages {
        stage('Get Source Code') {
            steps {
                git url: 'https://github.com/mahmood4/JavaSelenium.git'
                echo 'Hello World'
            }
        }
        stage('Build code')
                {
                    steps
                            {
                                bat script: 'mvn compile'
                            }
                }
        stage('Run Test')
                {
                    steps
                            {
                                bat "mvn clean package -PSanity -DskipTests=true"
                            }
                }
        stage('Publish Report')
                {
                    steps
                            {
                                publishHTML(target: [allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'C:\\Users\\User\\Downloads\\MyProject-master04\\MyStoreProject\\test-output\\', reportFiles: 'target/surefire-reports/Extent*.html', reportName: 'Pipeline', reportTitles: ''])
                            }
                }
    }
}
