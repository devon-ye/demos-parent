import socket;

server_socket = socket.socket();

ip_port = ("127.0.0.1",8888)

server_socket.bind(ip_port)

server_socket.listen(10)

print ("waiting receiving data....")

connect,address = server_socket.accept()

msg = "i received data."

connect.send(msg.encode())

connect.close()