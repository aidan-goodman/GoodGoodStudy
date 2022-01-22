package main

import (
	"fmt"
	"os"
)

// 匿名返回值的处理方法，包含错误的返回
func process(seed int) (int, error) {
	if seed < 100 {
		return seed * 10, nil
	}
	// 使用 `Errorf` 简单定义错误（字母全大写）
	return seed, fmt.Errorf("CAN'T PROCESS %d", seed)
}

// 进行去掉错误的封装
func process_plus(seed int) int {
	res, _ := process(seed)
	return res
}

func judge() {
	// 即便错误也不会报错
	fmt.Println(process_plus(100))

	if res, err := process(123); err != nil {
		fmt.Println(err)
		os.Exit(1) // 退出
	} else {
		fmt.Println(res)
	}

	// 中途退出不会打印
	fmt.Println("Program to run correctly")
}
