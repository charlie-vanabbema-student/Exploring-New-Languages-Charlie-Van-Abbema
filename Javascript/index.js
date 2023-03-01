const secretMessage = "73 115 32 105 110 115 105 110 99 101 114 105 116 121 32 115 117 99 104 32 97 "
    + "32 116 101 114 114 105 98 108 101 32 116 104 105 110 103 63 32 73 32 116 104 "
    + "105 110 107 32 110 111 116 46 32 73 116 32 105 115 32 109 101 114 101 108 121 "
    + "32 97 32 109 101 116 104 111 100 32 98 121 32 119 104 105 99 104 32 119 101 "
    + "32 99 97 110 32 109 117 108 116 105 112 108 121 32 111 117 114 32 112 101 114 "
    + "115 111 110 97 108 105 116 105 101 115 46"

console.log(AverageSecretMessage());
console.log(DecodeSecretMessage());
console.log(FizzBuzz(15));

function AverageSecretMessage() {
    const numberstext = secretMessage.split(" ");
    // console.log(numberstext)
    let sum = 0;
    for (var i = 0; i < numberstext.length; i++) {
        sum += parseInt(numberstext[i]);
    }
    return sum / numberstext.length;
}

function DecodeSecretMessage() {
    decodedSecretMessage = ""
    const numberstext = secretMessage.split(" ");
    for (var i = 0; i < numberstext.length; i++) {
        decodedSecretMessage += String.fromCharCode(parseInt(numberstext[i]));
    }
    return decodedSecretMessage
}

function FizzBuzz(number) {
    let arr = [];
    for(let i = 1; i <= number; i++) {
        if(i % 3 == 0 && i % 5 == 0) {
            arr.push("FizzBuzz");
        } else if(i % 3 == 0) {
            arr.push("Fizz");
        } else if(i % 5 == 0) {
            arr.push("Buzz");
        } else {
            arr.push(String(i));
        }
    }
    return arr;
    
}