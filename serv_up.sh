#scp ./*/target/*[!'BETA'].jar root@10.5.110.57:/data/application/tomcat-dlam/base-serv

scp -P 52020 ./*/target/*[!'BETA'].jar www@210.73.221.165:/data/application/base-server


scp ./zuul-server/target/*[!'BETA'].jar root@10.5.110.57:/data/application/tomcat-dlam/base-serv

scp -P 52020 ./zuul-server/target/*[!'BETA'].jar www@210.73.221.165:/data/application/base-server