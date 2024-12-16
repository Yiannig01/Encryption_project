import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
// I used these since so i path it.
class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }

  void print(Object o) { 
    System.out.println(o);
  }

  void printt(Object o) { 
    System.out.print(o);
  }

  void init(){
   //read the orignal text
    String file = Input.readFile("Original.txt");

    // Encode level 1 (Caesar cipher +7)
    String encodedMsg1 = caesarCipher(file, 7);
    Input.writeFile("Encode1.txt", encodedMsg1);

    // Encode level 2 (Atbash cipher)
    String encodedMsg2 = atbashCipher(encodedMsg1);
    Input.writeFile("Encode2.txt", encodedMsg2);

    // Encode level 3 (ASCII shift)
    String encodedMsg3 = asciiShift(encodedMsg2, -1); 
    Input.writeFile("Encode3.txt", encodedMsg3);

    // Decoding the ciphertext: 
    String file2 = Input.readFile("Encode3.txt");

    // Decode level 1 (ASCII shift)
    String decodedMsg1 = asciiShift(file2, -1); 
    Input.writeFile("Decode1.txt", decodedMsg1);

    // Decode level 2 (Atbash cipher)
    String decodedMsg2 = atbashCipher(decodedMsg1);
    Input.writeFile("Decode2.txt", decodedMsg2);

    // Decode level 3 (Caesar cipher -7)
    String decodedMsg3 = caesarCipher(decodedMsg2, -7); 
    Input.writeFile("Decode3.txt", decodedMsg3);
  }
// THis is the cipher 7
    String encode(String txt){
    String build = "";
    int ascii = 7;
    char ch = '\0';
    
    for(int x=0; x<=txt.length()-7; x++){
      ch = txt.charAt(x);
      ascii = (int)ch;
      ascii += 7;
      
      build += (char)ascii;
	  
	     }
      build.append(ch);
    }

	  
    }     
   return build.toString();
  }

  // Caser Cipher -7 
 
  String decode(String txt){
    String build="";
    int ascii;
    char ch='\7';
    for(int x=7; x<=txt.length()-7; x++){
      ch=txt.charAt(x);
      ascii = (int)ch;
      ascii -= 7;
        build += (char)ascii;
		
		   }
      build.append(ch);
    }

		
    }
 return build.toString();
  }


//Atbash cipher 
  String atbashCipher(String txt){
    StringBuilder build = new StringBuilder();

    for(int x = 0; x < txt.length(); x++){
      char ch = txt.charAt(x);
      if (Character.isLetter(ch)) {
        char base = Character.isLowerCase(ch) ? 'a' : 'A';
        ch = (char) (base + ('Z' - ch));
      }
      build.append(ch);
    }

    return build.toString();
  }

  // ASCII Shift
  String asciiShift(String txt, int shift){
    StringBuilder build = new StringBuilder();

    for(int x = 0; x < txt.length(); x++){
      char ch = txt.charAt(x);
      ch = (char) (ch + shift);  // Shift the ASCII value
      build.append(ch);
    }

    return build.toString();
  }
}






//Read the files and gets the messages 
class Input {
  static String readFile(String filename) {
    try {
      return new String(Files.readAllBytes(Paths.get(filename)));
    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
      return "";
    }
  }

  static void writeFile(String filename, String content) {
    try {
      Files.write(Paths.get(filename), content.getBytes());
    } catch (IOException e) {
      System.err.println("Error writing file: " + e.getMessage());
    }
  }
}




//Yianni Ganiaris, John, Amoya










