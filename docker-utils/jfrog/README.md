sudo vim /etc/hosts
<<
127.0.0.1       artifactory docker.artifactory docker-local.artifactory docker-remote.artifactory

sudo vim /etc/defaults/docker
<<
DOCKER_OPTS="$DOCKER_OPTS --insecure-registry docker-local.artifactory --insecure-registry docker-remote.artifactory --insecure-registry docker.artifactory"

docker-compose -f docker-compose.yml up --remove-orphans

http://localhost/artifactory
