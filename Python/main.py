import random
def AveragesecretMessage():
    with open("../secretMessage.txt") as f:
        lines = f.read()
        numbers = (list[int])(lines.split())
        sum = 0
        for num in numbers:
            sum += int(num)
        avg = sum / len(numbers)
        return avg
print(AveragesecretMessage())

def DecodesecretMessage():
    with open("../secretMessage.txt") as f:
        lines = f.read()
        numbers = (list[int])(lines.split())
        secretmessage = ""
        for num in numbers:
            secretmessage += (chr)(int(num))
        return secretmessage
print(DecodesecretMessage())

# def FizzBuzz(n):
#     thelist = [int]
#     for i in range(n):
#         if i % 3 == 0 and i % 5 == 0:
#             thelist.insert(i, "FizzBuzz")
#         elif i % 3 == 0 and i % 5 != 0:
#             thelist.insert(i, "Fizz")
#         elif i % 3 != 0 and i % 5 == 0:
#             thelist.insert(i, "Buzz")
#         else:
#             thelist.insert(i, "{i}")
# print(FizzBuzz(15))
def FizzBuzz(n: int) -> list[str]:
        return ["Fizz"*(d%3==0)+"Buzz"*(d%5==0) or f"{d}" for d in range(1,n+1)]
print(FizzBuzz(15))

def print_scaffold(guesses, wd): # prints the scaffold
    if (guesses == 0):
        print ("_________")
        print ("|	 |")
        print ("|")
        print ("|")
        print ("|")
        print ("|")
        print ("|________")
    elif (guesses == 1):
        print ("_________")
        print ("|	 |")
        print ("|	 O")
        print ("|")
        print ("|")
        print ("|")
        print ("|________")
    elif (guesses == 2):
        print ("_________")
        print ("|	 |")
        print ("|	 O")
        print ("|	 |")
        print ("|	 |")
        print ("|")
        print ("|________")
    elif (guesses == 3):
        print ("_________")
        print ("|	 |")
        print ("|	 O")
        print ("|	\|")
        print ("|	 |")
        print ("|")
        print ("|________")
    elif (guesses == 4):
        print("_________")
        print("|	 |")
        print("|	 O")
        print("|	\|/")
        print("|	 |")
        print("|")
        print("|________")
    elif (guesses == 5):
        print ("_________")
        print ("|	 |")
        print ("|	 O")
        print ("|	\|/")
        print ("|	 |")
        print ("|	/ ")
        print ("|________")
    elif (guesses == 6):
        print ("_________")
        print ("|	 |")
        print ("|	 O")
        print ("|	\|/")
        print ("|	 |")
        print ("|	/ \ ")
        print ("|________")
        print ("\n")
        print ("The word was %s." %wd)
        print ("\n")
        print ("\nYou lose!")
        print ("\nType 1 to play again, or type 2 to exit.")
        again = str(input("> "))
        again = again.lower()
        if again == "1":
            Hangman()
        return

def selectWord():
    with open("../Hangman_Words.txt") as f:
        lines = f.read()
        numbers = (lines.split())
        word = 'a'
        # word = random.randint(0, len(numbers))
        # while len(word) < 4:
            # word = random.choice(words)
        word = numbers[random.randint(0, len(numbers))]
            # word = str(word).strip('[]')
            # word = str(word).strip("''")
            # word = str(word).strip("\n")
            # word = str(word).strip("\r")
        word = word.lower()
        return word

def Hangman():
    guesses = 0
    word = selectWord()
    word_list = list(word)
    blanks = "_"*len(word)
    blanks_list = list(blanks)
    new_blanks_list = list(blanks)
    guess_list = []

    print("Let's play hangman!\n")
    print_scaffold(guesses, word)
    print("\n")
    print("" + ' '.join(blanks_list))
    print("\n")
    print("Guess a letter.\n")

    while guesses < 6:
        guess = str(input("> "))
        guess = guess.lower()

        if len(guess) > 1:
            print("Enter one letter at a time.")
        elif guess == "":
            print("GUESS A FRICKIN LETTER!")
        elif guess in guess_list:
            print("Already guessed...\nSo far you have guessed:")
            print(' '.join(guess_list))
        else:
            guess_list.append(guess)
            i = 0 
            while i < len(word):
                if guess == word[i]:
                    new_blanks_list[i] = word_list[i]
                i = i+1

            if new_blanks_list == blanks_list:
                print("Letter is not in word.")
                guesses = guesses + 1
                print_scaffold(guesses, word)

                if guesses< 6:
                    print("Guess again.")
                    print(' '.join(blanks_list))

            elif word_list != blanks_list:

                blanks_list = new_blanks_list[:]
                print(' '.join(blanks_list))

                if word_list == blanks_list:
                    print("\nCONGRATS, YOU WIN!!!!!!")
                    print("\n")
                    print("Want to play again?")
                    print("1 for yes, 2 for no")
                    again = str(input("> "))
                    if again == "1":
                        Hangman()
                    quit()

                else:
                    print("Correct guess!")

Hangman()





    # lives = 6
    # charactersLeft = 0
    # while lives != 0:
    #     for l in word:
    #         if l in word:
    #             print(l)
    #         else:
    #             print("_")
    #     print()
    #     if charactersLeft == 0:
    #         break
    #     print("Guess a letter: ")
