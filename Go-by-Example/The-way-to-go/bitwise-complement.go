package main

import "fmt"

func bitwise_comple() {
	for i := 1; i <= 10; i++ {
		fmt.Printf("the complement of %d is %b\n", i, ^i)

	}
}
