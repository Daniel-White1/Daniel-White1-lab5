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

        //remembered this is java not c so I dont have to use characters
        this.rotorValues = this.rotorValues.substring(1) + this.rotorValues.charAt(26);
        if (this.rotorValues.charAt(0) == this.startChar) {
            return true;
        }
        return false;
    }

    //search though the array and return the char
    public int indexOf(char c){
        for (int i = 0; i < 27; i++){
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
    
