# 오픈스택 개요

- ### 클라우드 서비스 모델

  - SaaS (Software as a Service)

    : 클라우드 환경에서 운영 중인 서비스 제공자의 애프리케이션을 사용자가 사용 할 수 있는 클라우드 컴퓨팅 모델

  - PaaS(Platform as s Service)

    : 서비스 공급자가 제공하는 프로그램 언어, 라이브러리, 서비스 그리고 툴을 사용해서 제작한 애플리케이션 또는 사용자가 직접 제작한 애플리케이션을 클라우드 환경에서 배포할 수 있도록 허용하는 클라우드 모델

  - Iaas(Intrastructure as a Service)

    : 프로세싱, 스토리지, 네트워크, 그리고 다른 기본적인 컴ㅂ퓨팅 자원들을 사용자에게 제공하는 클라우드 모델

    

- ### 오픈스택 개요

  : 오픈스택`openstack`은 위의 클라우드 컴퓨팅의 IaaS로서 클라우드 컴퓨팅 환경에서 사용되는 무료 오픈소스 클라우드 소프트웨어이다.

  

- ### 서비스 종류

  - Identity Service **Keystone**

    : 사용자 및 API에 대한 인증 및 권한 설정 서비스를 제공한다.

  - Image Service **Glance**

    : 다양한 하이퍼바이저에서 사용할 수 있는 가상 머신 이미지를 관리하고 가상머신에 설치 된 운영체제르 보관 및 관리.

     가상 디스크 이미지들을 저장/등록/관리/전달 하는 역할을 한다.

  - Network Service **Neutron**

    : 소프트웨어 기반의 네트워킹 서비스를 제공한다. (Quantum -> Neutron)

  - Compute Service **NOVA**

    : 가상머신 라이프사이클 관리자. 오픈스택에서 가장 핵심이다.

     클라우드 인프라 서비스 구축

     Nova가 지원하는 하이퍼바이저(가상화 OS)

    	- Qemu와 KVM
    	- Hyper-V와 Vmware, XenServer6.2
    	- Baremetal과 docker, Xen via libcir, LXC via libvirt

  - Blocked Storage Service **Cinder**

    : 범용의 저장장치를 기반으로 디스크 볼륨을 제공한다.

     -- VM이 Disk Storage가 부족해서 쓰는 서비스

  - Cloud Storage Service **Swift**

    : Rackspace CloudFiles를 기반으로 하는 오픈스택의 Object 저장소

     가상머신 이미지 파일(Glance)의 저장장치로 사용되기도 한다. 

     -- End-User가 Storage가 부족해서 쓰는 서비스

  - Dashboard service **Horizon**

    : 시스템 관리자 및 서비스 사용자를 위해 권한 별로 오픈스택 서비스를 이용할 수 있는 웹 기반의 사용자 인터페이스 환경을 제공한다.



#### * 참고 릴리즈 노트

[위키 openstack release notes](https://wiki.openstack.org/wiki/ReleaseNotes/Austin)

[openstack docs](https://docs.openstack.org/)



- ### 가상화 유형

  - Hypervisor

    - Full Virtualization (전 가상화) : over head가 크고, 성능이 떨어져 

      -> 해결하기 위해 CPU에 가상모드를 켜줌

      ex) `KVM`, `VMware`

    - Para Virtualization (반 가상화)  

      ex) `Xen`

  - Container

