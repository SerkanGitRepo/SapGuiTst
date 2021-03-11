node{


	stage('Build Test Image'){
		git url: 'https://github.com/SerkanGitRepo/SapGuiTst.git'
		//customImage = docker.build("testmvnprjtest:${env.BUILD_ID}")
		docker.build("test-gui:1")
	}
	 
	stage ('Smoke Test') {
		sh 'docker run -i -v $(pwd):/opt/myapp2 -w /home/SapGuiTst --network="hostgui" test-gui:1 mvn -f /home/SapGuiTst/pom.xml clean test -fn'
		//sh 'docker cp $(docker ps -aq --filter "network=host"):/home/CC_BDD_TNG/reports .'
		//publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: "/var/jenkins_home/workspace/SonPipelineSon/reports", reportFiles: "index.html", reportName: "HTML Report", reportTitles: "Test Raporu"])
		sh 'docker rm $(docker ps -aq --filter "network=hostgui")'
	}
}