package main

import "fmt"

func for_test() {
	i := 1
	for i <= 3 {
		fmt.Println(i)
		i = i + 1
	}

	for j := 7; j <= 9; j++ {
		fmt.Println(j)
	}

	for {
		fmt.Println("loop")
		break
	}

	str := "12345 "

	for c := range str {
		fmt.Printf("%x ", c)
	}
	println()
}
