pipeline {
	agent any
	
	stages {
		stage ('Compile Stage') {
		
			steps {
		    	withMaven(maven :'maven_4_0_0') {
					sh 'mvn clean compile'
			    }
			}
		}
		
		stage ('Package stage'){
		
			steps {
			   withMaven(maven :'maven_4_0_0') {
					sh 'mvn clean package'
			    }
			}
		}
		
		stage ('Install stage'){
		
			steps {
			   withMaven(maven :'maven_4_0_0') {
					sh 'mvn clean install'
			    }
			}
		}
	
	}
}