Name: daemon
Summary: daemon rpm 
Version: @VERSION@
Release: 1
License: GPL
Group: CKBI
Vendor: CKBI
URL: b.com
Source: daemon-@VERSION@.tar.gz
BuildRoot: @BUILDPATH@
BuildArch: noarch
Provides: daemon
Requires: jre

%description
Build daemon rpm

%prep

%setup -q

%build

%install

%clean

%files
%defattr (0700, root, root)
%attr(755,root,root) /etc/init.d/daemon
%defattr (0755, dsnet, dsnet)
%ghost /usr/lib/python2.4/cleverUtils.pyc
%ghost /usr/lib64/python2.4/cleverUtils.pyc
%dir /var/log/daemon
%dir /var/run/daemon
%dir /opt/daemon
%dir /opt/daemon/bin
%dir /opt/daemon/conf
%dir /opt/daemon/lib
%attr(755,dsnet,dsnet) /opt/daemon/conf/default.properties
%attr(644,dsnet,dsnet) /opt/daemon/conf/applicationContext.xml
%attr(644,dsnet,dsnet) /opt/daemon/conf/log4j.xml
%attr(644,dsnet,dsnet) /opt/daemon/lib/*.jar
%attr(644,dsnet,dsnet) /opt/daemon/lib/*.so

%post
/sbin/chkconfig --add daemon

%preun
if [ "$1" = "0" ]; then
    /sbin/chkconfig --del daemon
fi

