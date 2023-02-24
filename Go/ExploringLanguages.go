package main

import (
	"fmt"
	"os"
	// "path/filepath"
	// "io/ioutil"
	// "log"
	// "math/rand"
	// "strings"
	// "time"
	// "github.com/google/uuid"
)

func ReadFile(filepath string) []string {
	contents, err := os.ReadFile(filepath)
	if err != nil {
		fmt.Println("File reading error", err)
		return
	} else {
		fmt.Println(string(contents))
	}
}
func AverageSecretMessage() {
	// numbersText := ReadSecretMessage().Split(" ")
}

func main() {
	ReadFile("../secretMessage.txt")
	// AverageSecretMessage()

}
