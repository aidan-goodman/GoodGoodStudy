package main

import (
	"fmt"
	"net"
)

type Server struct {
	Ip   string
	Port int
}

// 创建一个 server 的接口
func NewServer(ip string, port int) *Server {
	server := &Server{
		Ip:   ip,
		Port: port,
	}
	// server.Ip = ip
	// server.Port = port
	return server
}

// 启动 Server
func (server *Server) Start() {
	// 1. socket listen
	listener, err := net.Listen("tcp", fmt.Sprintf("%s:%d", server.Ip, server.Port))
	if err != nil {
		fmt.Println("net.Listen error!: ", err)
		return
	}

	// 4. close
	defer listener.Close()

	for {

		// 2. accept
		conn, err := listener.Accept()
		if err != nil {
			fmt.Println("Listener accept error!: ", err)
			continue
		}

		// 3. do handle
		go server.Handle(conn) // 使用 goroutine 防止循环阻塞
	}
}

// 实际处理
func (server *Server) Handle(conn net.Conn) {
	fmt.Println("-----连接建立成功-----")
}
