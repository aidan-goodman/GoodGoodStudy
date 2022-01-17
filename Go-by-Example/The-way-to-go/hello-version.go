package main

import (
	"fmt"
	"runtime"
)

func hello_version() {
	fmt.Println(runtime.Version())

	// fmt.Println(runtime.GOOS)
}
