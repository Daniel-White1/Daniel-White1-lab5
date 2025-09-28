public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        if (this.rotorValues.charAt(0) == this.startChar) {
            return true;
        }
        return false;
    }

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
    
