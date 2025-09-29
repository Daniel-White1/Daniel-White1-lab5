public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        //I am going to be quite honest here. I've tried to keep this constuctor untouched however
        //I don't quite know how to keep this while loop unmodified to make this code work and I've bounced my head off the wall a lot
        //So im gonna change this
        while(this.rotorValues.charAt(0) != startChar){
            //now this while loop calls to rotate the rotor until the first value of the rotor matches the start character
            this.rotate();
        }
            
    }
    
    public boolean rotate(){
        //create a temprorary array to store the rotated string
        char[] temp = new char[27];
        //rotor char is the og rotor string converted into a char array
        char[] rotor_char = this.rotorValues.toCharArray();
        //temp copys the values 0~25 into 1~26 spots on its array
        for(int i = 0; i < 26; ++i){
            temp[i+1] = rotor_char[i];
        }
        //then the temporary value is changed to the last value in the rotor string
        temp[0] = rotor_char[26];
        //convert the temp array into a string and place it into the rotor values spot
        this.rotorValues = temp.toString();

        //check to see if the rotor values at 0 is equal to the starting character
        //if it is true then return true otherwise return false
        if (rotorValues.charAt(0) == this.startChar) {
            return true;
        }
        return false;
    }

    //search though the array and return the char
    public int indexOf(char c){
        for (int i = 0; i < 26; i++){
            if (this.rotorValues.charAt(i) == c) {
                return i;
            }
        }
        
        //return -1 for some error is somehow the index doesnt have it
        return -1;
    }

    public char charAt(int idx){
        return this.rotorValues.charAt(idx);
    }
}
    
