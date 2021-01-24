package com.example.pesel_validator.pesel

class Validator {
    companion object{
        fun invalid(pesel: String): Boolean{
            return pesel.length != 11 || !pesel.matches("[0-9]+".toRegex());
        }

        fun isMale(pesel: String): Boolean{
            if(invalid(pesel)) throw Error("Pesel must be 11 digits only")
            else{
                return (pesel[pesel.length - 2].toInt())%2 != 0
            }
        }

        fun isFemale(pesel: String): Boolean{
            if(invalid(pesel)) throw Error("Pesel must be 11 digits only")
            else{
                return (pesel[pesel.length - 2].toInt())%2 == 0
            }
        }

        fun getBirthDate(pesel: String): String{
            if(invalid(pesel)) throw Error("Pesel must be 11 digits only")
            else {
                val year = pesel.substring(0,2).toInt()
                val month = pesel.substring(2,4)
                val day = pesel.substring(4,6)
                val fullYear = year + if(year < 20) 2000 else 1900

                return "$day-$month-$fullYear"
            }
        }

        fun checkSum(pesel: String): Boolean{
            if(invalid(pesel)) throw Error("Pesel must be 11 digits")
            else{
                val a = pesel[0].toInt()
                val b = pesel[1].toInt()
                val c = pesel[2].toInt()
                val d = pesel[3].toInt()
                val e = pesel[4].toInt()
                val f = pesel[5].toInt()
                val g = pesel[6].toInt()
                val h = pesel[7].toInt()
                val i = pesel[8].toInt()
                val j = pesel[9].toInt()
                val k = pesel[10].toInt()
                val sum = a + 3*b + 7*c + 9*d + e + 3*f + 7*g + 9*h + i + 3*j + k;
                return sum % 10 == 0
            }
        }

    }
}