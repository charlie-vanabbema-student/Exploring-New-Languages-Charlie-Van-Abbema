package main

import (
	"fmt"
	"strconv"
	"strings"
	"math/rand"
	// "container/list"

	// "io"
	"os"
	// "path/filepath"
	// "io/ioutil"
	// "log"
	"time"
	// "github.com/google/uuid"
)

func main() {
	b, err := os.ReadFile("../secretMessage.txt")
	if err != nil {
		fmt.Print(err)
	}

	var str string = string(b)

	// fmt.Print(str)
	fmt.Println(AverageSecretMessage(str))
	fmt.Println(DecodeSecretMessage(str))
	fmt.Println(FizzBuzz(15))
	fmt.Println(GetRandomWord())

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
	arr := make([]string, n+1)
	for i := 1; i <= n; i++ {
		if i%3 == 0 && i%5 == 0 {
			arr[i] = "FizzBuzz"
		} else if i%3 == 0 {
			arr[i] = "Fizz"
		} else if i%5 == 0 {
			arr[i] = "Buzz"
		} else {
			// strI := strconv.Itoa(i)
			arr[i] = strconv.Itoa(i)
			// arr = append(arr, string(rune(i)))
		}
	}
	return arr
}
func GetRandomWord() string {
	b, err := os.ReadFile("../Hangman_Words.txt")
	if err != nil {
		fmt.Print(err)
	}
	var str string = string(b)
	words := strings.Fields(str)
	rand.Seed(time.Now().UnixNano())
	randnum := rand.Intn(len(words) + 1)
	word := words[randnum]
	return word
}



func CorrectGuess(guess string, letters []string) bool {
	for _, letter := range letters {
		if guess == letter {
			return true
		}
	}
	return false
}

func PrintWord(letters []string, used map[string]bool) string {
	word := ""
	for _, letter := range letters {
		if used[letter] {
			word += letter
		} else {
			word +=  "_"
		}
	}
	return word
}


func Hangman() {
	// letters := strings.Split(word, "")
	word = GetRandomWord();
	PrintWord()
	
}



	
