package main

import (
	"fmt"
)

type ErrNegativeSqrt float64

func (e ErrNegativeSqrt) Error() string {
	// 使用 `float64(e)` 的形式
	return fmt.Sprintf("cannot Sqrt negative number: %v", float64(e))
}

func SqrtByError(x float64) (float64, error) {
	if x <= 0 {
		// 自身会根据返回类型调用 `Error()`
		return float64(0), ErrNegativeSqrt(x)
	}

	z := x
	next := float64(0)
	for {
		z = z - (z*z-x)/2*z
		if (next > z && (next-z) < 0.1) || (z > next && (z-next) < 0.1) {
			break
		}
		next = z
	}
	return next, nil
}
