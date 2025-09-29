public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        //so this is just encyption but backwards pretty much
        String result = "";
        for(int i = 0; i < message.length(); i++){
            //gets the character we are encypting
            char encryptedChar = message.charAt(i);
            
            //next we have to go though each rotor but backwards
            //ie: find character on outer -> find its index
            //find the character in the middle ring in the same index
            //then find the same character from the middle ring in the outer ring
            //finally grab that outer index location and find the character that is in the same index in the inner layer
            int index1 = rotors[2].indexOf(encryptedChar);
            char middleChar = rotors[1].charAt(index1);
            int index2 = rotors[2].indexOf(middleChar);
            char innerChar = rotors[0].charAt(index2);
            //next add the new char to result
            result = result + innerChar;

            //then rotate the rotors
            rotate();
        }
        //finally return the resulting string
        return result;
        
    }


    //im going to work here first because in my mind its easier to write encryption first
    public String encrypt(String message){
        String result = "";
        for(int i = 0; i < message.length(); i++){
            //gets the character we are encypting
            char startChar = message.charAt(i);
            
            //next we have to go though each rotor.
            //ie: find character on inner -> find its index
            //find the character in the outer ring in the same index
            //then find the same character from the outer ring in the middle ring
            //finally grab that middle index location and find the character that is in the same index in the outer ring
            int index1 = rotors[0].indexOf(startChar);
            char outerChar = rotors[2].charAt(index1);
            int index2 = rotors[1].indexOf(outerChar);
            char encryptedChar = rotors[2].charAt(index2);

            //next add the new char to result
            result = result + encryptedChar;

            //then rotate the rotors
            rotate();
        }
        //finally return the resulting string
        return result;
        
    }


    //This simulates the rotation of the enimga machine rotating each rotor once the lower one is rotated.
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
