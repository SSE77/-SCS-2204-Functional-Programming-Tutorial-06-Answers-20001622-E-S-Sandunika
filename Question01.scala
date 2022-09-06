object CaeserCipherCase
{
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    def encryption():Any=
    {
        val sendmassage = scala.io.StdIn.readLine("The massage needed to be sent: ")
        val shift = (scala.io.StdIn.readLine("Shift from: ").toInt + alphabet.size) % alphabet.size

        val encryptedmassage = sendmassage.map((c:Char) => 
        {
            val x = alphabet.indexOf(c.toUpper)
            if(x == -1) 
            {
                c
            }
            else 
            {
                alphabet((x + shift) % alphabet.size) 
            }
        });

        println(encryptedmassage);
    }
    
    def decryption():Any=
    {
        val  sendmassage= scala.io.StdIn.readLine("The encrypted message to be decrypted: ")
        val back = (alphabet.size - scala.io.StdIn.readLine("Backward By: ").toInt) % alphabet.size

        val decryptedmassage = sendmassage.map((c:Char) => 
        {
            val x = alphabet.indexOf(c.toUpper)

            if(x == -1) 
            {
                c
            }
            else 
            {
                alphabet((x + back) % alphabet.size)
            }
        });
        println(decryptedmassage);
    }

    def main(args: Array[String]) = 
    {
        println("Cesar's cipher algorithm")
        println("1. Encrypt message")
        println("2. Decrypt message")
        val choice = scala.io.StdIn.readLine("1 or 2 : ").toInt

        choice match 
        {
            case choice if (choice == 1) => encryption()
            case choice if (choice == 2) => decryption()
            case _ => println("An invalid input!")
        }
    }
}