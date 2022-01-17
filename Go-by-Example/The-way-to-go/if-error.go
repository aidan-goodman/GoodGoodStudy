package main

import (
	"fmt"
)

func process(seed int) (int, error) {
	if seed < 100 {
		return seed * 10, nil
	}
	return seed, fmt.Errorf("CAN'T PROCESS %d", seed)
}

func judge() {
	if res, err := process(123); err != nil {
		fmt.Println(err)
	} else {
		fmt.Println(res)
	}
}
