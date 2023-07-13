package test;


public class User {
    private String name;
     
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Username cannot be blank");
        } else {
        	 if (name.isEmpty()) {
                throw new IllegalArgumentException("Username is Empty");
            }
             else if (name.length() > 30) {
                throw new IllegalArgumentException("Username is too long");
            }
            
            else if (name.length() < 3) {
                 throw new IllegalArgumentException("Username is too short");
             }
            else if (name.trim().length() == 0) {
                throw new IllegalArgumentException("Username is Blank Spaces Only");
            }
            
        }
         
        this.name = name;
    }
}
