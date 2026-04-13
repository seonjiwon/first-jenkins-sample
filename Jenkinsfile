pipeline {
    agent any

    stages {
        stage('Gradle build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker build -t seonjiwon-spring .'
                sh 'docker stop seonjiwon-spring || true'
                sh 'docker rm seonjiwon-spring || true'
                sh 'docker run -d --name seonjiwon-spring -p 12225:8080 seonjiwon-spring'
            }
        }
    }
}