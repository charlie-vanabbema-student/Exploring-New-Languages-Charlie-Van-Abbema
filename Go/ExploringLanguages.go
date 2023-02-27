package main

import (
	"fmt"
	"strconv"
	"strings"

	// "container/list"

	// "io"
	"os"
	// "path/filepath"
	// "io/ioutil"
	// "log"
	// "math/rand"
	// "time"
	// "github.com/google/uuid"
)

func main() {
	b, err := os.ReadFile("../secretMessage.txt")
	if err != nil {
		fmt.Print(err)
	}

	var str string = string(b)

	// fmt.Print(str)
	println(AverageSecretMessage(str))
	println(DecodeSecretMessage(str))
	println(FizzBuzz(15))
}

func AverageSecretMessage(str string) int {
	numberstext := strings.Fields(str)

	var numbers = []int{}

	for _, i := range numberstext {
		num, err := strconv.Atoi(i)
		if err != nil {
			panic(err)
		}
		numbers = append(numbers, num)
	}
	sum := 0
	for i := 0; i < len(numbers); i++ {
		sum += numbers[i]
	}
	return sum / len(numbers)
}

func DecodeSecretMessage(str string) string {
	numberstext := strings.Fields(str)
	secretmessage := ""
	var numbers = []int{}

	for _, i := range numberstext {
		num, err := strconv.Atoi(i)
		if err != nil {
			panic(err)
		}
		numbers = append(numbers, num)
	}
	for i := 0; i < len(numbers); i++ {
		secretmessage += string(rune(numbers[i]))
	}
	return secretmessage
}

func FizzBuzz(n int) []string {
	arr := []string{}
	for i := 1; i <= n; i++ {
		if i%3 == 0 && i%5 == 0 {
			arr = append(arr, "FizzBuzz")
		} else if i%3 == 0 {
			arr = append(arr, "Fizz")
		} else if i%5 == 0 {
			arr = append(arr, "Buzz")
		} else {
			arr = append(arr, strconv.Itoa(i))
		}
	}
	return arr
}
