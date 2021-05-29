pipeline {
	agent any
	
	stages {
		stage ('Compile Stage') {
		
			steps {
					sh 'mvn clean compile'
			}
		}
		
		stage ('Package stage'){
		
			steps {
					sh 'mvn clean package'
			}
		}
		
		stage ('Install stage'){
		
			steps {
					sh 'mvn clean install'
			}
		}
	
	}
}