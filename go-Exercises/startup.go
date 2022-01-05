package main

import (
	"fmt"

	"golang.org/x/tour/pic"
)

func main() {
	// Case1: Hello, World!
	fmt.Println("Hello 世界")

	// Case2: Cycle and function
	fmt.Println(Sqrt(9.0))

	// Case3: Slice
	pic.Show(Pic)

	// Case4: map
	fmt.Println(WordCount("akj asg ajk dk asd xx zxnm wi zxio qrl"))

	// Case5: fibonacci
	f := Fibonacci()
	for i := 0; i < 10; i++ {
		fmt.Println(f())
	}

	// Case6: Stringer
	hosts := map[string]IPAddr{
		"loopback":  {127, 0, 0, 1},
		"googleDNS": {8, 8, 8, 8},
	}
	for name, ip := range hosts {
		fmt.Printf("%v: %v\n", name, ip)
	}

	// Case7: Error
	fmt.Println(SqrtByError(-2))

}
