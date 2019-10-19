package main

func channel(str string) {
	ch := make(chan string)
	ch <- str
	close(ch)

}
