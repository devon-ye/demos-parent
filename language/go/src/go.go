package main

import (
	"fmt"
	"log"
	"net/http"
	"strings"
)

func main() {
	http.HandleFunc("/", sayHelloName)       //设置访问的路由
	err := http.ListenAndServe(":9090", nil) //设置监听的端口

	if err != nil {
		log.Fatal("ListenAndServe: ", err)
	}
}

func sayHelloName(w http.ResponseWriter, r *http.Request) {
	r.ParseForm() //解析参数，默认不解析

	fmt.Println(r.Form) //这些信息输出到服务端的打印信息

	fmt.Println("path", r.URL.Path)

	fmt.Println("schema", r.URL.Scheme)

	fmt.Println(r.Form["url_long"])

	for k, v := range r.Form {
		fmt.Println("key", k)
		fmt.Println("value", strings.Join(v, ""))

	}

	fmt.Fprintf(w, "HELLO astaxie!")

}
