package main

import (
	"fmt"
	"os"
)
func ReadSecretMessage() {
	contents, err := os.ReadFile("../secretMessage.txt")
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
	ReadSecretMessage()
	// AverageSecretMessage()

}


