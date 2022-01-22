package main

import "fmt"

func switch_demo() {
	k := 6
	switch k { // 1. 普通的值判断情况
	case 5:
		fmt.Println("was <= 5")
		fallthrough
	case 6:
		fmt.Println("was <= 6")
		fallthrough
	case 7:
		fmt.Println("was <= 7")
		fallthrough
	default:
		fmt.Println("default case")
	}

	switch { // 2. 表达式的判断
	case k < 10:
		fmt.Println("k < 10")
		fmt.Println("Don't need braces")
	case k < 20:
		fmt.Println("k < 20")
	default:
		fmt.Println("default case")
	}

	switch i, j := 10, 20; { // 3. 初始化的场景
	case i < j:
		fmt.Println(j)
	default:
		fmt.Println(i)

	}
}
