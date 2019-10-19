package main

import (
	"net"
)


func socket_connect(ip string,port int)(conn net.Conn,error){
	var socket = ip+ ":" + string(port)
    conn, err =	net.Dial("TCP",socket)
    if  err != nil{
    	return nil,err
	}
	//	Dial("tcp", "golang.org:http")
	//	Dial("tcp", "192.0.2.1:http")
	//	Dial("tcp", "198.51.100.1:80")
	//	Dial("udp", "[2001:db8::1]:domain")
	//	Dial("udp", "[fe80::1%lo0]:53")
	//	Dial("tcp", ":80")
    return conn,nil
}
