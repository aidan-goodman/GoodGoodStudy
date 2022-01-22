package main

import "strings"

func WordCount(s string) map[string]int {
	m := make(map[string]int)

	c := strings.Fields(s)

	for _, v := range c {
		m[v]++
	}
	return m
}
