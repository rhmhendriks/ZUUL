import java.util.Stack;
import java.util.Collections;

/**
 * Write a description of class Questions here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Questions
{
    private Stack<Question> it1;
    private Stack<Question> it2;
    private Stack<Question> it3;
    
    /**
     * Constructor for objects of class Questions
     */
    public Questions()
    {
            //Create stack questions for difficulty 1 and insert corresponding data
            it1 = new Stack<Question>();
            it1.add (new Question("Wat is het verschil tussen een int en void functie?","Een int retourneert alleen een getal en een void retourneert niets*,Een int retourneert alleen een getal en een void retourneert alles,Een int retourneert alleen een getal zonder decimalen en een void retourneert een getal met decimalen", 1, 0));
            it1.add (new Question("Wat is het datatype van de waarde TRUE?", "Boolean", 1, 0));
            it1.add (new Question("Vul het juiste woord in: Objecten slaan gegevens op in ______", "Velden", 1, 0));
            it1.add (new Question("Wat moet er bovenaan je script staan als je een ArrayList wil gebruiken?", "import java.util.ArrayList", 1, 0));
            it1.add (new Question("Schrijf het omhulsel van een klasse met de naam \"Name\"", "Public class Name", 1, 0));
            it1.add (new Question("What is an example of a top-level domain?", "www.cisco.com,cisco.com,.com*,root.cisco.com", 1, 0));
            it1.add (new Question("Maak een veld voor het gegeven \"prijs\" waarin men een bedrag kan invullen","private int prijs", 1, 0));
            it1.add (new Question("An user is unable to reach the web site when typing http://www.cisco.com in a web browser, but can reach the same site by typing http://72.163.4.161. What is the issue?","default gateway,DHCP,DNS*,TCP/IP protocol stack", 1, 0));
            it1.add (new Question("Which connection provides a secure CLI session with encryption to a switch?", "a console connection,an AUX connection,a Telnet connection,an SSH connection*", 1, 0));
            it1.add (new Question("What protocol is responsible for controlling the size of segments and the rate at which segments are exchanged between a web client and a web server?", "TCP*,IP,HTTP,Ethernet", 1, 0));
            it1.add (new Question("What is a characteristic of UTP cabling?", "Cancellation*,cladding,immunity to electrical hazards,woven copper braid or metallic foil", 1, 0));
            it1.add (new Question("Which statement is true about variable-length subnet masking?", "Each subnet is the same size.,The size of each subnet may be different depending on requirements.*,Subnets may only be subnetted one additional time.,Bits are returned rather than borrowed to create additional subnets.", 1, 0));
            it1.add (new Question("What is a key characteristic of the peer-to-peer networking model?", "wireless networking,social networking without the Internet,network printing using a print server,resource sharing without a dedicated server*", 1, 0));
            it1.add (new Question("A technician can ping the IP address of the web server of a remote company but cannot successfully ping the URL address of the same web server. Which software utility can the technician use to diagnose the problem?", "tracert,ipconfig,netstat,nslookup*", 1, 0));
            it1.add (new Question("A wireless host needs to request an IP address. What protocol would be used to process the request?","FTP,HTTP,DHCP*,ICMP,SNMP", 1, 0));
            it1.add (new Question("A company is expanding its business to other countries. All branch offices must remain connected to corporate headquarters at all times. Which network technology is required to support this requirement?", "LAN,MAN,WAN*,WLAN", 1, 0));
            it1.add (new Question("A home user is looking for an ISP connection that provides high speed digital transmission over regular phone lines. What ISP connection type should be used?", "DSL*,dial-up,satellite,cell modem,cable modem", 1, 0));
            it1.add (new Question("What is a characteristic of Ethernet MAC addresses?", "They are globally unique.*,They are routable on the Internet.,MAC addresses use a flexible hierarchical structure.,MAC addresses must be unique for both Ethernet and serial interfaces on a device.", 1, 0));
            it1.add (new Question("Which command can be used on a Windows host to display the routing table?","netstat -s,show ip route,netstat -r*,tracert", 1, 0));
            it1.add (new Question("What network service resolves the URL entered on a PC to the IP address of the destination server?", "DNS*,DHCP,FTP,SNMP", 1, 0));
            it1.add (new Question("What characteristic of a network enables it to quickly grow to support new users and applications without impacting the performance of the service being delivered to existing users?", "reliability,scalability*,quality of service,accessibility", 1, 0));
            it1.add (new Question("A conditional that lets you make multiple comparisons with a pattern is called ", "fanout,if,branch,case*,test", 1, 0));
            it1.add (new Question("A division of a hard drive may be referred to as a _______ . ", "Partition*,label,block", 1, 0));
            it1.add (new Question("The fdisk command is a tool used for working with the MBR partitioned disks.", "True*,False", 1, 0));
            it1.add (new Question("Which of the following are valid video cable connector types?", "AMD & DVI,DVI & VGA*,VGA & HDA,HDA & AMD", 1, 0));
            it1.add (new Question("A command that will continuously update statistics about running processes: ", "top*,tail,bottom,head", 1, 0));
            it1.add (new Question("Which of the following commands will allow you to log into the machine server1 with the account name nick?", "ssh nick@server1*,ssh nick->server1,ssh nick-server1,ssh nick&server1", 1, 0));
            it1.add (new Question("The RSA key fingerprint allows the dig command to connect to remote systems", "True,False*", 1, 0));
            it1.add (new Question("Wat is de juiste volgorde?", "Klasse - Object - Constructor*,Object - Constructor - Klasse,Object - Klasse - Constructor", 1, 0));
            it1.add (new Question("Which file does not contain user account information?", "/etc/shadow,/etc/group*,/etc/passwd", 1, 0));
            it1.add (new Question("Sudo privileges can be used to specify which user can use the sudo command to execute commands as other users.", "True*,False", 1, 0));
            it1.add (new Question("In distributions that do not allow the root user to login directly or via the su command, the installation process automatically configures one user account to be able to use the sudo command to execute commands as if they were executed by the root user.", "True*,False", 1, 0));
            it1.add (new Question("Which command will display how long the system has been running since the last boot?", "who,id,uptime*,status", 1, 0));
            it1.add (new Question("The /etc/shadow file contains plain-text passwords.", "True,False*", 1, 0));
            it1.add (new Question("Which of the following files contains encrypted user password information?", "/etc/usr,/etc/shadow*,/etc/passwd,/etc/group", 1, 0));
            it1.add (new Question("Which of the following files contains user IDs? ", "/etc/passwd*,/etc/group,/etc/shadow,/etc/usr", 1, 0));
            it1.add (new Question("The chmod command can be used on a file by: ", "The file owner and ro errorsot*,The file owner,A user that belongs to the files current group,Only root", 1, 0));
            it1.add (new Question("The chown command will only accept one file at a time as an argument", "True,False*", 1, 0));
            it1.add (new Question("The “execute�? permission is never set on files by default.", "True*,False", 1, 0));
            it1.add (new Question("The user owner of a file will always have the same or higher permissions as “other�?.", "True,False*", 1, 0));
            it1.add (new Question("Unix is: ", "An operating system*,A type of hardware,A distribution of Linux,A text editor", 1, 0));
            it1.add (new Question("What is the standard option to provide a command line program to view its documentation?", "–info,–doc,–help*,-h", 1, 0));
            it1.add (new Question("Which Windows technology increases system performance by using flash memory?", "Direct Memory Access,File compression,Connect Now,ReadyBoost*", 1, 0));
            it1.add (new Question("Which Windows feature allows you to request that someone else control your computer from their computer?", "Remote Assistance*,Action Center,Sync Center,Connect Now", 1, 0));
            it1.add (new Question("You want to upgrade your Windows operating system to Windows 7. Which feature should you use to find out whether the existing devices will work after the upgrade?", "System Manager,Windows 7 Compatibility Center*,Device Manager,Windows Update", 1, 0));
            it1.add (new Question("A Windows 7 library:", "Organizes user files from disparate locations.*,Makes copies of user files in a central location.,Encrypts files by using the Encrypting File System (EFS).,Restores files from system backup.", 1, 0));
            it1.add (new Question("Which Windows 7 feature should you use to ensure that only administrators can install new software?", "Network and Sharing Center,User Account Control*,Microsoft Management Console,Ease of Access", 1, 0));
            it1.add (new Question("Which Windows feature allows you to roll back your computers settings to a previous date and time?", "System Restore*,Safe Mode,Disk Cloning,Disk Mirroring", 1, 0));
            it1.add (new Question("You need to remotely control another computer by using a Remote Desktop connection. Where should you start the Remote Desktop Connection client?", "From the Actions menu in Windows Live Messenger,From the User Accounts settings in Control Panel,From the Accessories folder in All Programs*,From the Internet Options dialog box in Internet Explorer", 1, 0));
            it1.add (new Question("Which Windows feature should you use to protect a computer against spyware?", "Group Policy,User Account Control,Windows Defender*,Encrypting File System", 1, 0));
            it1.add (new Question(" You need a script to run at a specific time. Which Windows component should you use?", "Task Manager,Device Manager,Task Scheduler*,Event Viewer", 1, 0));
            it1.add (new Question("You need to modify the time displayed in the system tray. Which Control Panel feature should you use?", "Appearance and Personalization,Display Properties,Administrative Tools,Clock Language and Region", 1, 0));
            it1.add (new Question("You want to change your default home page in Internet Explorer. In which location should you modify settings?", "Trusted Sites, View, Internet Options*, Favorites", 1, 0));

            //Create stack questions for difficulty 2 and insert corresponding data
            it2 = new Stack<Question>();
            it2.add (new Question("Welke waarde heeft het 13e array-element in een Array genaamd Lijst?", "Lijst[12]", 2, 0));
            it2.add (new Question("Waarom is het niet altijd aan te raden om import java.util.* te gebruiken?","Deze functie wordt niet meer door Java ondersteund,Deze functie omvat niet alle Java packages,Het programma wordt hierdoor erg traag*", 2, 0));
            it2.add (new Question("Wat is een geldige reden om een Stack te gebruiken ipv een Array(List)","De rij met gegevens mag niet worden aangepast,Je wilt meer functionaliteit toevoegen aan een rij met gegevens,Je wilt van een rij gegevens alleen de laatste waarde halen*", 2, 0));
            it2.add (new Question("What is a characteristic of multicast messages?", "They are sent to a select group of hosts.*,They are sent to all hosts on a network.,They must be acknowledged.,They are sent to a single destination.", 2, 0));
            it2.add (new Question("What is one indication that a Windows computer did not receive an IPv4 address from a DHCP server?", "The computer cannot ping 127.0.0.1.,Windows displays a DHCP timeout message.,The computer receives an IP address that starts with 169.254.*,The computer cannot ping other devices on the same network with IP addresses in the 169.254.0.0/16 range.", 2, 0));
            it2.add (new Question("What is a characteristic of a fault tolerant network?", "a network that protects confidential information from unauthorized access,a network that can expand quickly to support new users and applications without impacting the performance of the service delivered to existing users,a network that supports a mechanism for managing congestion and ensuring reliable delivery of content to all users,a network that recovers quickly when a failure occurs and depends on redundancy to limit the impact of a failure*", 2, 0));
            it2.add (new Question("What is a benefit of using cloud computing in networking?", "End users have the freedom to use personal tools to access information and communicate across a business network.,Network capabilities are extended without requiring investment in new infrastructure or personnel or software.*,Technology is integrated into every-day appliances allowing them to interconnect with other devices which makes them more ‘smart’ or automated.,Home networking uses existing electrical wiring to connect devices to the network wherever there is an electrical outlet which saves the cost of installing data cables.", 2, 1));
            it2.add (new Question("What is the function of the shell in an OS? ","It interacts with the device hardware.,It interfaces between the users and the kernel.*,It provides dedicated firewall services.,It provides the intrusion protection services for the device.", 2, 0));
            it2.add (new Question("A network technician is attempting to configure an interface by entering the following command: SanJose(config)# ip address 192.168.2.1 255.255.255.0. The command is rejected by the device. What is the reason for this?", "The command is being entered from the wrong mode of operation.*,The command syntax is wrong.,The subnet mask information is incorrect.,The interface is shutdown and must be enabled before the switch will accept the IP address.", 2, 0));
            it2.add (new Question("What is an advantage to using a protocol that is defined by an open standard?", "A company can monopolize the market.,The protocol can only be run on equipment from a specific vendor.,An open standard protocol is not controlled or regulated by standards organizations.,It encourages competition and promotes choices.*", 2, 0));
            it2.add (new Question("What will a host on an Ethernet network do if it receives a frame with a destination MAC address that does not match its own MAC address?", "It will discard the frame.*,It will forward the frame to the next host.,It will remove the frame from the media.,It will strip off the data-link frame to check the destination IP address.", 2, 0));
            it2.add (new Question("Which frame forwarding method receives the entire frame and performs a CRC check to detect errors before forwarding the frame?", "cut-through switching,store-and-forward switching*,fragment-free switching,fast-forward switching", 2, 0));
            it2.add (new Question("What addresses are mapped by ARP?", "destination MAC address to a destination IPv4 address*,destination IPv4 address to the source MAC address,destination IPv4 address to the destination host name,destination MAC address to the source IPv4 address", 2, 0));
            it2.add (new Question("Which service is provided by the OSI network layer?","performing error detection,routing packets toward the destination*,placement of frames on the media,collision detection", 2, 0));
            it2.add (new Question("What purpose does NAT64 serve in IPv6? ", "It converts IPv6 packets into IPv4 packets.*,It translates private IPv6 addresses into public IPv6 addresses.,It enables companies to use IPv6 unique local addresses in the network.,It converts regular IPv6 addresses into 64-bit addresses that can be used on the Internet.,It converts the 48-bit MAC address into a 64-bit host address that can be used for automatic host addressing.", 2, 0));
            it2.add (new Question("A user opens three browsers on the same PC to access www.cisco.com to search for certification course information. The Cisco web server sends a datagram as a reply to the request from one of the web browsers. Which information is used by the TCP/IP protocol stack in the PC to identify which of the three web browsers should receive the reply?", "the destination IP address,the destination port number*,the source IP address,the source port number", 2, 0));
            it2.add (new Question("What is a way that TCP uses the sequence numbers in a segment?", "to identify missing segments at the destination*,to specify the order in which the segments travel from source to destination,to limit the number of segments that can be sent out of an interface at one time,to determine if the packet changed during transit", 2, 0));
            it2.add (new Question("Which task is a function of the presentation layer?","addressing,encryption*,session control,authentication", 2, 0));
            it2.add (new Question("A PC obtains its IP address from a DHCP server. If the PC is taken off the network for repair, what happens to the IP address configuration?", "The configuration is permanent and nothing changes.,The address lease is automatically renewed until the PC is returned.,The address is returned to the pool for reuse when the lease expires.*,The configuration is held by the server to be reissued when the PC is returned.", 2, 0));
            it2.add (new Question("Which example of malicious code would be classified as a Trojan horse?", "malware that was written to look like a video game*,malware that requires manual user intervention to spread between systems,malware that attaches itself to a legitimate program and spreads to other programs when launched,malware that can automatically spread from one system to another by exploiting a vulnerability in the target", 2, 0));
            it2.add (new Question("How does quality of service help a network support a wide range of applications and services?", "by limiting the impact of a network failure,by allowing quick recovery from network failures,by providing mechanisms to manage congested network traffic*,by providing the ability for the network to grow to accommodate new users", 2, 0));
            it2.add (new Question("What layer is responsible for routing messages through an internetwork in the TCP/IP model?", "Internet*,transport,network access,session", 2, 0));
            it2.add (new Question("What unique address is embedded in an Ethernet NIC and used for communication on an Ethernet network?", "host address,IP address,MAC address*,network address", 2, 0));
            it2.add (new Question("Which procedure is used to reduce the effect of crosstalk in copper cables? ", "requiring proper grounding connections,twisting opposing circuit wire pairs together*,wrapping the bundle of wires with metallic shielding,designing a cable infrastructure to avoid crosstalk interference,avoiding sharp bends during installation", 2, 0));
            it2.add (new Question("During the encapsulation process, what occurs at the data link layer for a PC connected to an Ethernet network?", "An IP address is added.,The logical address is added.,The physical address is added.*,The process port number is added.", 2, 0));
            it2.add (new Question("If a device receives an Ethernet frame of 60 bytes, what will it do?", "drop the frame*,process the frame as it is,send an error message to the sending device,add random data bytes to make it 64 bytes long and then forward it", 2, 0));
            it2.add (new Question("Which switching method has the lowest level of latency?", "cut-through,store-and-forward,fragment-free,fast-forward*", 2, 0));
            it2.add (new Question("Which function is a primary function of a router?", "packet forwarding*,microsegmentation,domain name resolution", 2, 0));
            it2.add (new Question("At a minimum, which address is required on IPv6-enabled interfaces?", "link-local*,unique local,site local,global unicast", 2, 0));
            it2.add (new Question("What is a characteristic shared by TCP and UDP?", "default window size,connectionless communication,port numbering*,3-way handshake,ability to to carry digitized voice", 2, 0));
            it2.add (new Question("Why are port numbers included in the TCP header of a segment?", "to indicate the correct router interface that should be used to forward a segment,to identify which switch ports should receive or forward the segment,to determine which Layer 3 protocol should be used to encapsulate the data,to enable a receiving host to forward the data to the appropriate application*,to allow the receiving host to assemble the packet in the proper order", 2, 0));
            it2.add (new Question("Which protocol operate at the highest layer of the TCP/IP protocol stack?", "DNS*,Ethernet,IP,TCP,UDP", 2, 0));
            it2.add (new Question("What is the dotted decimal representation of the IPv4 address 11001011.00000000.01110001.11010011?","192.0.2.199,198.51.100.201,203.0.113.211*,209.165.201.223", 2, 0));
            it2.add (new Question("During data communications, a host may need to send a single message to a specific group of destination hosts simultaneously. This message is in the form of a _________ message. (2)", "Multicast", 2, 0));
            it2.add (new Question("A medium-sized business is researching available options for connecting to the Internet. The company is looking for a high speed option with dedicated, symmetric access. Which connection type should the company choose?", "DSL,dialup,satellite,leased line*,cable modem", 2, 0));
            it2.add (new Question("What is the purpose of having a converged network?", "to provide high speed connectivity to all end devices,to make sure that all types of data packets will be treated equally,to achieve fault tolerance and high availability of data network infrastructure devices,to reduce the cost of deploying and maintaining the communication infrastructure*", 2, 0));
            it2.add (new Question("After several configuration changes are made to a router, the copy running-configuration startup-configuration command is issued. Where will the changes be stored?", "flash,ROM,NVRAM*,RAM,the configuration register,a TFTP server", 2, 0));
            it2.add (new Question("The number of users logged in is in a variable called USERS. How would you test to see if 5 users are logged in?", "test $USERS = 5,test $USERS –a 5,test –f USERS=5,test $USERS –eq 5*", 2, 0));
            it2.add (new Question("Which of the following are valid partitioning types?", "MBR & GPT*,PC & MBR,GPT & BIOS,BIOS & PC", 2, 0));
            it2.add (new Question("Which of the following is the valid device file name for the first IDE hard drive on the system", "/dev/sda,/dev/hd1,/dev/hda*,/dev/ide", 2, 0));
            it2.add (new Question("Which file contains the information passed to the kernel at boot time?", "/proc/kargs,/proc/kernel,/proc/kopts,/proc/cmdline*", 2, 0));
            it2.add (new Question("To get a list of all packages installed on a system using RPM Package Management you can execute: ", "rpm -qa*,rpm -ql,rpm -qf,rpm -qi", 2, 0));
            it2.add (new Question("Which of the following would be considered a host?", "The computer’s hard drive,A network cable,A CDROM,A printer attached to the network via an IP address*", 2, 0));
            it2.add (new Question("What option to the netstat command has information shown as numbers rather than names?", "-t,-n*,–name,-r", 2, 0));
            it2.add (new Question("Which command can be used to view the /etc/passwd file entries?", "getent*,uptime,getpasswd,uppasswd", 2, 0));
            it2.add (new Question("Which command can be used to determine a user’s most recent log in?", "login,last*,history,shell", 2, 0));
            it2.add (new Question("Which of the following commands, run as root, will prevent the user bob from logging in? ", "usermod -L bob*,usermod -D bob,usermod -d bob,usermod -l bob", 2, 0));
            it2.add (new Question("Which option for the chown command can be used to change the owner of a directory and all the files and directories below it? ", "-f,-R*,-a,-r", 2, 0));
            it2.add (new Question("Deleting a source file will break an associated symbolic link.", "True*,False", 2, 0));
            it2.add (new Question("A source file and a symbolic link must be part of the same file system. ", "True,False*", 2, 0));
            it2.add (new Question("Linux is written in: ", "C*,.NET,C++,Java,Perl", 2, 0));
            it2.add (new Question("Source code refers to: ", "The version of a program that the computer runs on the CPU,The license that dictates how you may use and share the software,The interface that software uses to talk to the kernel,A human readable version of computer software*", 2, 0));
            it2.add (new Question("The directory where additional documentation for software packages most likely can be found is:", "/var/lib/doc,/usr/software/doc,/usr/share/doc*,/var/share/doc", 2, 0));
            it2.add (new Question("What option for the ls command will display all files, including hidden files?", "-w,-H,-L,-a*", 2, 0));
            it2.add (new Question("The Remote Desktop Connection is used to:", "search the Internet.,attend a webinar.,access another personal computer.*,conduct a Lync Online Meeting.", 2, 0));
            it2.add (new Question("Which feature allows you to manually configure a hardware device?", "Windows Task Manager,Ease of Access,Device Manager*,Registry Editor", 2, 0));
            it2.add (new Question("Which is the largest single file that you can store on a FAT32 file system?", " 4GB*,8GB,16GB,32GB", 2, 0));
            it2.add (new Question("Which feature should you use to install the most recent definitions for Windows Defender?", "Windows Update*,Sync Center,Windows Installer,Programs and Features", 2, 0));
            it2.add (new Question("Which describes the purpose of Power Saver mode for a portable computer?", "To lock the computer when it is idle,To prevent unauthorized programs from consuming resources,To protect the display from burned-in images,To shut down idle devices to conserve battery charge*", 2, 0));
            it2.add (new Question("Which feature ensures that your personal computer always has the latest patches and fixes for the operating system?", "Reliability and Performance Monitor,Programs and Features,System Configuration Utility,Windows Update*", 2, 0));
            it2.add (new Question("Windows hides some files by default to:", "Avoid accidental modification or deletion of system files.*,Protect the confidentiality of the contents of files.,Improve access to system files.,Save disk space.", 2, 0));
            it2.add (new Question("Which file system is designed for transfer of large files between a personal computer and flash devices?", "FAT16 file system,FAT32 file system,exFAT file system*,NTFS file system", 2, 0));
            it2.add (new Question("You plan to upgrade your computer to Windows 7. Which tool should you use to find out whether your current applications will run on Windows 7?", "Application Compatibility Toolkit*,Windows Anytime Upgrade,Windows Update,Windows Service Pack", 2, 0));
            it2.add (new Question("The purpose of a Public folder is to:", "share files with only one person on a network.,share files with everyone on a network.*,share files with a selected group of people on a network.,back up files to a location on a network.", 2, 0));
            it2.add (new Question("BitLocker prevents:", "The operating system from overwriting protected sectors on the hard disk drive.,Unauthorized users from accessing the Internet.,Unauthorized access to files.*,Programs from accessing the memory of other programs.", 2, 0));
            it2.add (new Question("You need to allow others to access your Windows 7 computer by using the Remote Desktop connection. What should you do?", "Click Turn on network discovery in Network and Sharing Center.,Enable Remote Desktop Connections in System Properties.*,Start the Remote Desktop Connection client in Accessories.,Set the security level to medium in Internet Options.", 2, 0));
            it2.add (new Question("Which program will run on a 64-bit version of the Windows operating system?", "A 32-bit laser printer driver,A 32-bit video card driver,A 32-bit version of Microsoft Office*,A 32-bit wireless network adapter driver", 2, 0));
            it2.add (new Question("Which action will trigger a user account control (UAC) prompt in Windows?", "Accessing the Internet,Changing the time zone,Installing a new program*,Restarting Windows,Changing settings in the Display Properties dialog box", 2, 0));
            it2.add (new Question("Which prevents you from establishing a Remote Desktop connection to a remote computer?", "Incorrect monitor settings in Device Manager.,Incorrect screen resolution in the Display Properties dialog box.,Incorrect port settings in Windows Firewall.*,Incorrect security settings in Internet Explorer.", 2, 0));
            it2.add (new Question("You want to upgrade your computer from Windows Vista to Windows 7. What is the minimum processor speed required to run a 64-bit version of Windows 7?", "800 MHz,1.0 GHz*,1.2 GHz,1.8 GHz", 2, 0));
            it2.add (new Question("Which of the following files does the groupadd command use to determine the new GID when a GID isn’t specified? ", "/etc/shadow,/etc/usr,/etc/passwd,/etc/group*", 2, 0));
            it2.add (new Question("What is a characteristic of multicast transmission?","The source address of a multicast transmission is in the range of 224.0.0.0 to 224.0.0.255.,A single packet can be sent to a group of hosts.*,Computers use multicast transmission to request IPv4 addresses.,Multicast messages map lower layer addresses to upper layer addresses.", 2, 0));
            it2.add (new Question("What is a range of IP addresses that are reserved for internal private use?","64.100.0.0/14,127.16.0.0/12,192.31.7.0/24,192.168.0.0/16*", 2, 0));
            it2.add (new Question("Wat is het verschil tussen een Array en een ArrayList in Java?","Een ArrayList kan alleen gegevens van bovenaf halen en een Array kan van elke plek gegevens halen,Een Array heeft een vast aantal gegevens en een ArrayList heeft oneindig*,Een Array wordt niet gebruikt in Java maar ArrayList wel", 2, 0));

            //Create stack for questions for difficulty 3 and insert corresponding data
            it3 = new Stack<Question>();
            it3.add (new Question("A network technician suspects that a particular network connection between two Cisco switches is having a duplex mismatch. Which command would the technician use to see the Layer 1 and Layer 2 details of a switch port?", "show interfaces*,show running-config,show ip interface brief,show mac-address-table", 3, 0));
            it3.add (new Question("What source IP address does a router use by default when the traceroute command is issued?", "the highest configured IP address on the router,a loopback IP address,the IP address of the outbound interface*,the lowest configured IP address on the router", 3, 0));
            it3.add (new Question("Three bank employees are using the corporate network. The first employee uses a web browser to view a company web page in order to read some announcements. The second employee accesses the corporate database to perform some financial transactions. The third employee participates in an important live audio conference with other corporate managers in branch offices. If QoS is implemented on this network, what will be the priorities from highest to lowest of the different data types?", "audio conference; financial transactions; web page*,financial transactions; web page; audio conference,audio conference; web page; financial transactions,financial transactions; audio conference; web page", 3, 0));
            it3.add (new Question("On which switch interface would an administrator configure an IP address so that the switch can be managed remotely?", "FastEthernet0/1,VLAN 1*,vty 0,console 0", 3, 0));
            it3.add (new Question("What is a benefit of using a layered network model?", "It speeds up packet delivery.,It prevents designers from creating their own model.,It prevents technology in one layer from affecting other layers.*,It ensures a device at one layer can function at the next higher layer.", 3, 0));
            it3.add (new Question("What are two characteristics of fiber-optic cable?", "It is not affected by EMI or RFI and is more expensive than UTP cabling is.*,Each pair of cables is wrapped in metallic foil and typically contains 4 pairs of fiber-optic wires.", 3, 0));
            it3.add (new Question("What is a characteristic of the LLC sublayer? ", "It provides the logical addressing required that identifies the device.,It provides delimitation of data according to the physical signaling requirements of the medium.,It places information in the frame allowing multiple Layer 3 protocols to use the same network interface and media.*,It defines software processes that provide services to the physical layer.", 3, 0));
            it3.add (new Question("A network team is comparing physical WAN topologies for connecting remote sites to a headquarters building. Which topology provides high availability and connects some, but not all, remote sites?", "mesh,partial mesh*,hub and spoke,point-to-point", 3, 0));
            it3.add (new Question("What method is used to manage contention-based access on a wireless network?", "CSMA/CD,priority ordering,CSMA/CA*,token passing", 3, 0));
            it3.add (new Question("What is the most compressed representation of the IPv6 address 2001:0000:0000:abcd:0000:0000:0000:0001? ", "2001:0:abcd::1,2001:0:0:abcd::1*,2001::abcd::1,2001:0000:abcd::1,2001::abcd:0:1", 3, 0));
            it3.add (new Question("Which range of link-local addresses can be assigned to an IPv6-enabled interface?", "FEC0::/10,FDEE::/7,FE80::/10*,FF00::/8", 3, 0));
            it3.add (new Question("Which scenario describes a function provided by the transport layer?","A student is using a classroom VoIP phone to call home. The unique identifier burned into the phone is a transport layer address used to contact another network device on the same network.,A student is playing a short web-based movie with sound. The movie and sound are encoded within the transport layer header.,A student has two web browser windows open in order to access two web sites. The transport layer ensures the correct web page is delivered to the correct browser window.*,A corporate worker is accessing a web server located on a corporate network. The transport layer formats the screen so the web page appears properly no matter what device is being used to view the web site.", 3, 0));
            it3.add (new Question("Which statement accurately describes a TCP/IP encapsulation process when a PC is sending data to the network?", "Data is sent from the internet layer to the network access layer.,Packets are sent from the network access layer to the transport layer.,Segments are sent from the transport layer to the internet layer.*,Frames are sent from the network access layer to the internet layer.", 3, 0));
            it3.add (new Question("Under which circumstance will a switch flood a frame out of every port except the port that the frame was received on?", "The destination address is unknown to the switch.*,The source address in the frame header is the broadcast address.,The source address in the frame is a multicast address.,The destination address in the frame is a known unicast address.", 3, 0));
            it3.add (new Question("Which service provides dynamic global IPv6 addressing to end devices without using a server that keeps a record of available IPv6 addresses?", "stateful DHCPv6,SLAAC*,static IPv6 addressing,stateless DHCPv6", 3, 0));
            it3.add (new Question("What is the purpose of the command ping ::1?", "It tests the internal configuration of an IPv6 host.*,It tests the broadcast capability of all hosts on the subnet.,It tests the multicast connectivity to all hosts on the subnet.,It tests the reachability of the default gateway for the network.", 3, 0));
            it3.add (new Question("How many usable IP addresses are available on the 192.168.1.0/27 network?", "256,254,62,30*,16,32", 3, 0));
            it3.add (new Question("What single subnet mask would be appropriate to use for the three subnetworks?","255.255.255.0,255.255.255.240*,255.255.255.248,255.255.255.252", 3, 0));
            it3.add (new Question("What subnet mask is needed if an IPv4 network has 40 devices that need IP addresses and address space is not to be wasted?", "255.255.255.0,255.255.255.128,255.255.255.192*,255.255.255.224,255.255.255.240", 3, 0));
            it3.add (new Question("What is a function of NVRAM? ", "to store the routing table,to retain contents when power is removed*,to contain the running configuration file,to store the ARP table", 3, 0));
            it3.add (new Question("How many valid host addresses are available on an IPv4 subnet that is configured with a /26 mask? ", "254,190,192,62*,64", 3, 0));
            it3.add (new Question("A site administrator has been told that a particular network at the site must accommodate 126 hosts. Which subnet mask would be used that contains the required number of host bits?","255.255.255.0,255.255.255.128*,255.255.255.224,255.255.255.240", 3, 0));
            it3.add (new Question("Which subnet would include the address 192.168.1.96 as a usable host address?","192.168.1.64/26*,192.168.1.32/27,192.168.1.32/28,192.168.1.64/29", 3, 0));
            it3.add (new Question("What is one difference between the client-server and peer-to-peer network models? ", "Only in the client-server model can file transfers occur.,Every device in a peer-to-peer network can function as a client or a server.*,A peer-to-peer network transfers data faster than a transfer using a client-server network.,A data transfer that uses a device serving in a client role requires that a dedicated server be present.", 3, 0));
            it3.add (new Question("Which networking model is being used when an author uploads one chapter document to a file server of a book publisher?", "peer-to-peer,master-slave,client/server*,point-to-point", 3, 0));
            it3.add (new Question("A network engineer is analyzing reports from a recently performed network baseline. Which situation would depict a possible latency issue?", "a change in the bandwidth according to the show interfaces output,a next-hop timeout from a traceroute,an increase in host-to-host ping response times*,a change in the amount of RAM according to the show version output", 3, 0));
            it3.add (new Question("Which firewall feature is used to ensure that packets coming into a network are legitimate responses to requests initiated from internal hosts?", "stateful packet inspection*,URL filtering,application filtering,packet filtering", 3, 0));
            it3.add (new Question("What is the meaning of $(( $i + 1))?", "If i is 0 then the loop will stop,This will return the value of the first argument to the script,1 will be added to the i variable*,This runs the command stored in variable i,This will return the value of the next argument to the script", 3, 0));
            it3.add (new Question("Welke van de volgende Linux option styles klopt niet?", "Traditional Unix with a single dash (-),BSD Unix without a dash,DOS slash (/)*,GNU long options with two dashes (–)", 3, 0));
            it3.add (new Question("To make changes permanent for kernel parameter files found under /proc/sys, the following file can have entries added to it: ", "/etc/sysctl.conf*,/etc/procctl.conf,/etc/procsys.conf,/etc/sysinfo.conf", 3, 0));
            it3.add (new Question("A source and a hard link must be part of the same filesystem.", "True*,False", 3, 0));
            it3.add (new Question("Which of the following commands would create a hard link, link to file?", "ln link file,ln -s link file,ln file link*,ln -s file link", 3, 0));
            it3.add (new Question("Which of the following commands would create a symbolic link, link to file?", "ln link file,ln -s file link*,ln file link", 3, 0));
            it3.add (new Question("One of the jobs of the kernel is to: ", "Manage the system’s resources*,Turn source code into machine code,Load the operating system after the computer is turned on,Transfer mail from one machine to another", 3, 0));
            it3.add (new Question("The command man -k is the same as the command apropos.", "True*,False", 3, 0));
            it3.add (new Question("The whatis command is the same as man -w.", "True,False*", 3, 0));
            it3.add (new Question("You need to install Windows 7 over an existing version of Windows. Which type of installation should you use to retain all your files, settings, and programs on your computer?", "Use the Windows Easy Transfer tool, and select Custom (advanced).,Use the Windows 7 installation disk to perform a system repair.,Use the Windows Easy Transfer tool, and select Upgrade.*,Use the Windows 7 installation disk to perform a clean installation.", 3, 0));
            it3.add (new Question("Which Windows feature allows you to manually control another Windows computer?", "Remote Control Monitor,Remote Desktop Connection*,Remote Power Management,Remote Procedure Call", 3, 0));
            it3.add (new Question("You insert a software installation CD into your Windows 7 computer. The CD does not launch automatically. You need to perform a manual installation. What should you do?", "From Control Panel, use Programs., From Control Panel, use Ease of Access.,Browse the contents of the hard disk drive and locate the Program Files folder.,Browse the contents of the CD and locate the Setup file.*", 3, 0));
            it3.add (new Question("You need to find out whether your computer can run a program that performs resource- intensive tasks. Which Windows feature should you use?", "System Configuration Utility,Memory Diagnostics Tool,Reliability and Performance Monitor,Windows Experience Index*", 3, 0));
            it3.add (new Question("Which feature allows you to transfer information from your computer to your mobile phone?", "Windows Mobility Center,Device Manager*,Sync Center,Windows Easy Transfer", 3, 0));
            it3.add (new Question("Which feature allows you to change the display resolution of a computer monitor?", "Computer Management Console,System Configuration Tool,Appearance and Personalization*,Device Manager", 3, 0));
            it3.add (new Question("Which feature allows you to pause the printing of all documents waiting to print on a specific printer?", "The Print Setup page,The printer's Properties page,The printer's shortcut menu*,The Computer Management console", 3, 0));
            it3.add (new Question("Which feature allows you to run applications hosted on network file servers or web servers?", "Windows Virtual PC,Remote Desktop Connection,Windows Installer,Application Virtualization Client*", 3, 0));
            it3.add (new Question("Welke van de uitspraken over het verschil tussen Java en Javascript is NIET juist?","Java wordt gecompileerd naar bytecode en Javascript wordt regel voor regel voor regel geïnterpreteerd,Bij Javascript moeten toekenningen precies kloppen en Java ziet dit door de vingers*,Java is een complete programeertaal en Javascript verzorgt alleen programma's in HTML-pagina's", 2, 0));

            Collections.shuffle(it1);
            Collections.shuffle(it2);
            Collections.shuffle(it3);
}

    ////////////////////////////////////////////////////
    /// The methods below are used to get some       ///
    /// of these questions in a specified categorys  ///
    ////////////////////////////////////////////////////

        public boolean getRandomQuestion(int Category, int difficulty, Player activePlayer){
           boolean noMoreQuestions = false;
             // lets findout what list to use
             if (Category == 0){
                 // category is IT now we select the dif level to find the right stack
                 if (difficulty == 1 || difficulty == 4){
                     if (!it1.isEmpty()){
                        while(!it1.pop().processQuestion(activePlayer));
                     } else if (!it2.isEmpty()){
                        while(!it2.pop().processQuestion(activePlayer));
                      } else if (!it3.isEmpty()){
                        while(!it3.pop().processQuestion(activePlayer));
                       } else { 
                        noMoreQuestions = false;
                         }
                     } else if (difficulty == 2 || difficulty == 5){
                        if (!it2.isEmpty()){
                           while(!it2.pop().processQuestion(activePlayer));
                        } else if (!it3.isEmpty()){
                           while(!it3.pop().processQuestion(activePlayer));
                        } else if (!it1.isEmpty()){
                           while(!it1.pop().processQuestion(activePlayer));
                        } else { 
                           noMoreQuestions = false;
                        }

                      } else if (difficulty == 3 || difficulty == 6){
                        if (it3.isEmpty()){
                           while(!it3.pop().processQuestion(activePlayer));
                        } else if (!it2.isEmpty()){
                           while(!it2.pop().processQuestion(activePlayer));
                        } else if (!it1.isEmpty()){
                           while(!it1.pop().processQuestion(activePlayer));
                        } else { 
                           noMoreQuestions = false;
                        }
                     } // voor andere cat: else if (category == <cat int>){ if (difficulty == <difint>){ else if (difficulty == <difint>){ } } }
                     
                  }  
                  return noMoreQuestions;
               }
               
}
