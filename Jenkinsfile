pipeline {
    agent any

    tools{
        maven'Maven'
    }
    
    stages {
        stage('Clonar repositorio') {
            steps {
                git branch: 'main', url: 'https://github.com/JesusLopezGomez/calculadoraSpring.git'
            }
        }

        stage('Construir la aplicación') {
            steps {
                sh 'mvn clean package -DskipTests=true'
            }
        }


        stage('Deploy') {
            steps{
                    echo 'Despligue realizado con éxito'
            }
        }

    }
}
