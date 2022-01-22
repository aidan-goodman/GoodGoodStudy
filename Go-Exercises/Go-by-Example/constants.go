package main

import (
	"fmt"
	"math"
	"strconv"
)

const n = 1000000

func constants() {
	const a = 123
	const b = 456
	const s = "123456"

	fmt.Println(n)
	fmt.Println(float64(a))

	fmt.Println(b / a)

	fmt.Println(math.Sin(n))
	d, _ := strconv.Atoi(s)
	fmt.Println(d)
}
