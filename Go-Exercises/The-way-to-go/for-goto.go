package main

import "fmt"

func for_goto() {

LABEL1:
	for i := 0; i <= 5; i++ {
		for j := 0; j <= 5; j++ {
			if j == 4 {
				// 标签的作用对象为外部循环，i 变成下一个循环的值
				continue LABEL1
			}
			// 当 j==4 和 j==5 的时候，没有输出
			fmt.Printf("i is: %d, and j is: %d\n", i, j)
		}
	}

}
