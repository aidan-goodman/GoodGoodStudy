package main

import (
	"fmt"
	"math/rand"
)

func random() {
	for i := 0; i < 5; i++ {
		fmt.Println(rand.Int())
	}

	fmt.Println("=============")

	for i := 0; i < 5; i++ {
		fmt.Println(rand.Intn(10))
	}
}
