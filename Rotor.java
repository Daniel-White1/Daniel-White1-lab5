public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }

    public String getRotorValue() {
        return rotorValues;
    }

    public String setRotorValue(String a) {
        this.rotorValues = a;
        return rotorValues;
    }
    
    public boolean rotate(){
        if (this.rotorValues.charAt(0) == this.startChar) {
            return true;
        }
        return false;
    }

    public int indexOf(char c){
        for (int i = 0; i < 26; i++){
            if (Rotor.rotorValues.charAt(i) == c) {
                return i;
            }

        }
    }

    public char charAt(int idx){
        return Rotor.rotorValues.charAt(idx);
    }
}
    
