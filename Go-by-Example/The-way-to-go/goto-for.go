package main

import "fmt"

func goto_for() {
	for i := 0; i < 15; i++ {
		fmt.Printf("The counter is at %d\n", i)
	}

	// 使用 goto 代替循环
	i := 0
START:
	fmt.Printf("The counter is at %d\n", i)
	i++
	if i < 15 {
		goto START
	}
}
