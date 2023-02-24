package main

import (
	"fmt"
	"os"
	"path/filepath"
	"io/ioutil"
	"log"
	"math/rand"
	"strings"
	"time"
	"github.com/google/uuid"
)

func ReadFile(filepath string) []string {
	b, err := ioutil.ReadFile(filePath) // read words from file
	if err != nil {
		log.Fatal(err)
	}

	str := string(b) // convert content to a 'string'
	words := strings.Split(str, "\n")
	return words
}
func AverageSecretMessage() {
	// numbersText := ReadSecretMessage().Split(" ")
}

func main() {
	ReadFile("../secretMessage.txt")
	// AverageSecretMessage()

}
