pipeline {
	agent any
	
	stages {
	   stage ('Checkout Stage') {
		
			steps {
					git_checkoutBranch(
						branch: "master"
					)
			}
		}
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