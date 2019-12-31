# CentOs Controller 시작하기

설치 후에

```shell
# yum repolist						// 인터넷 되는지 확인
# yum update -y						// 업데이트 파일 다운로드
```



### 리눅스의 보안 메커니즘

- 방화벽
- SELinux

```shell
# systemctl stop firewalld
# systemctl disable firewalld
# systemctl disable NetworkManager
# systemctl stop NetworkManager
# setenforce 0						
```

setenforce는 reboot되면 원래대로 돌아오기 때문에 vi /etc/selinux/config 를 열어서 7번 줄에 있는 `SELINUX=disabled`로 수정한다음 저장한다.



### 가상화 지원 여부 확인하기

```shell
# egrep '(vmx|svm)' /proc/cpuinfo
또는
# lscpu								//에서 virtualization 항목에서 확인 가능
```



### 호스트 정보 확인하기

```shell
# cat /etc/*release					//version info
# hostnamectl
# ip a								//en33 ip 주소가 10.0.0.100인지 확인
```



### NTP 서버 구성

**NTP 서버 란?**  Network Time Protocol의 약어로서 정확한 시간을 제공하는 서버 프로그램이다.

```shell
# yum install chrony -y
# vim /etc/chrony.conf				//server 수정
// # ntpdate time.nuri.net			//nuri.net에서 시간가져와서 동기화(시간 설정)
# ntpdate 2.kr.pool.ntp.org			//nuri.net 서비스가 종료되어서 다른걸로 동기화
# date								//날짜 동기화 되었는지 확인
# systemctl restart chronyd			//시스템 재부팅
# systemctl enable chronyd
# chronyc sources
```



![](./pic/chrony.conf_edit.PNG)

> /etc/chrony.conf 파일 수정 모습
>
> NTP Client 구성

![](./pic/chronyc.PNG)

> NTP 서버가 소스로 사용하는 세대의 NTP 서버 정보를 받아오고 있는지 확인한다.



```shell
# vi /etc/hosts
```

![](./pic/etc_hosts.PNG)

>  /etc/hosts파일 수정

### Openstack repository 등록

```shell
# yum install -y centos-release-openstack-rocky
# yum repolist
# yum upgrade -y
```



설치할때 만들었던 C:\openstack\controller 파일 아래에 있는 `Controller.vmdk`파일을 복사해서 상위 폴더인 `openstack`에 붙여넣고 새로운 파일 `compute1`을 만들어서 또 붙여넣는다. 이때 이름을 `compute1.vmdk`로 수정한다.



### Packstack 설치

```shell
# yum install -y openstack-packstack*
```

### Packstack으로 Openstack 설치

```shell
# packstack --gen-answer-file=/root/openstack.txt
# cp /root/openstack.txt /root/openstack.org
# pwd
# vi /root/openstack.txt
```



#### 변경 내용

```shell
CONFIG_DEFAULT_PASSWORD=abc123				//:11
CONFIG_CEILOMETER_INSTALL=n					//:46
CONFIG_AODH_INSTALL=n						//:50
CONFIG_KEYSTONE_ADMIN_PW=abc123				//:326
CONFIG_PROVISION_DEMO=n						//:1185
CONFIG_NEUTRON_OVS_BRIDGE_IFACES=br-ex:ens33	//:873
```

그 외 

CONFIG_CLIENT_INSTALL=y				잘 설치 되어 있는지 확인 //:70 

Glance, Cinder, Neutron, Swift 등 설치되어 있는지 확인



```shell
# time packstack --answer-file=/root/openstack.txt
```

대략 20~30분 정도 걸린다.
설치가 완료되면
![](./pic/install.png)
화면이 뜨고 나와있는 주소를 인터넷으로 들어가보면
![](./pic/openstackhp.PNG)
창이 뜨는것을 볼 수 있다.
