package main

func Fibonacci() func() int {
	x, y := 0, 1

	return func() int {
		result := x
		x, y = y, x+y
		return result
	}
}
