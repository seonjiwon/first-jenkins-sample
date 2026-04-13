pipeline {
    agent any

    stages {
        stage('Gradle build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }
        }

        stage('Deploy to Dev') {
            when { branch 'dev' }
            steps {
                sh 'docker build -t seonjiwon-spring-dev .'
                sh 'docker stop seonjiwon-spring-dev || true'
                sh 'docker rm seonjiwon-spring-dev || true'
                sh 'docker run -d --name seonjiwon-spring-dev -p 12226:8080 seonjiwon-spring-dev'
            }
        }

        stage('Approval') {
            when { branch 'main' }
            steps {
                input message: '프로덕션 배포를 승인하시겠습니까?',
                        ok: '배포'
            }
        }

        stage('Deploy to Prod') {
            when { branch 'main' }
            steps {
                sh 'docker build -t seonjiwon-spring .'
                sh 'docker stop seonjiwon-spring || true'
                sh 'docker rm seonjiwon-spring || true'
                sh 'docker run -d --name seonjiwon-spring -p 12225:8080 seonjiwon-spring'
            }
        }
    }
}