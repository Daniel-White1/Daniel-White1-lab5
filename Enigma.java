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
        String result = new String();
        for(int i = 0; i < message.length(); i++){
            //gets the character we are encypting
            char e_char = message.charAt(i);
            
            //next we have to go though each rotor but backwards
            //ie: find character on outer -> find its index
            //find the character in the middle ring in the same index
            //then find the same character from the middle ring in the outer ring
            //finally grab that outer index location and find the character that is in the same index in the inner ring
            int index = rotors[2].indexOf(e_char);
            e_char = rotors[1].charAt(index);
            index = rotors[1].indexOf(e_char);
            e_char = rotors[2].charAt(index);

            //next add the new char to result
            result = result + e_char;

            //then rotate the rotors
            rotate();
        }
        //finally return the resulting string
        return result;
        
    }


    //im going to work here first because in my mind its easier to write encryption first
    public String encrypt(String message){
        String result = new String();
        for(int i = 0; i < message.length(); i++){
            //gets the character we are encypting
            char e_char = message.charAt(i);
            
            //next we have to go though each rotor.
            //ie: find character on inner -> find its index
            //find the character in the outer ring in the same index
            //then find the same character from the outer ring in the middle ring
            //finally grab that middle index location and find the character that is in the same index in the outer ring
            int index = rotors[0].indexOf(e_char);
            e_char = rotors[2].charAt(index);
            index = rotors[1].indexOf(e_char);
            e_char = rotors[2].charAt(index);

            //next add the new char to result
            result = result + e_char;

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
