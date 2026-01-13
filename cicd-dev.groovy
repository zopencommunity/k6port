node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/k6port.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/k6port.git'), string(name: 'PORT_DESCRIPTION', value: 'Grafana k6 load testing tool' ), string(name: 'BUILD_LINE', value: 'DEV'), string(name: 'NODE_LABEL', value: 'go_120' ) ]
  }
}