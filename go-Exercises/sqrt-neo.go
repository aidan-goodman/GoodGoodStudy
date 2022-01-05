package main

func Sqrt(x float64) float64 {
	z := x
	next := float64(0)
	for {
		z = z - (z*z-x)/2*z
		// 可以使用 math 包下的 Abs() 简写，精度的判断也可以使用 1e-10
		if (next > z && (next-z) < 0.1) || (z > next && (z-next) < 0.1) {
			break
		}
		next = z
	}
	return next
}
