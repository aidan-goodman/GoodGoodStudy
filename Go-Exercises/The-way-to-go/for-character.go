package main

import (
	"fmt"
	"strings"
)

func for_character() {
	for i := 1; i < 6; i++ {
		for j := 0; j < i; j++ {
			fmt.Print("G")
		}
		fmt.Println()
	}

	fmt.Println("=================")

	var str string = ""
	for i := 1; i < 6; i++ {
		str += strings.Repeat("G", i)
		str += "\n"
	}
	fmt.Println(str[0 : len(str)-1]) // 去除末尾多余的换行
}
