package FactoryPattern;

class Namer { // a class to take a string apart into two names

    protected String last; //store last name here
    protected String first; //store first name here

    public String getFirst() {
        return first; //return first name
    }

    public String getLast() {
        return last; //return last name
    }
}

class FirstFirst extends Namer {

    public FirstFirst(String s) {
        int i = s.lastIndexOf(" "); //find separating space
        if (i > 0) {
            first = s.substring(0, i).trim();  //left = first name
            last = s.substring(1 + 1).trim();  //right = last name
        } else {
            first = ""; //put all in last name
            last = s; //if no space
        }
    }
}

class LastFirst extends Namer { //split last, first

    public LastFirst(String s) {
        int i = s.indexOf(","); //find comma
        if (i > 0) {
            last = s.substring(0, i).trim(); //left = last name
            first = s.substring(i + 1).trim(); //right = first name
        } else {
            last = s; //put all in last name
            first = ""; //if no comma
        }
    }
}

class NameFactory {

    //returns an instance of LastFirst or FirstFirst
    //depending on whether a comma is found
    public Namer getNamer(String entry) {
        int i = entry.indexOf(","); //comma determines name order
        if (i > 0) {
            return new LastFirst(entry); //return one class
        } else {
            return new FirstFirst(entry);  //or the other
        }
    }
}

class UseClass {

    public static void main(String[] args) {
        NameFactory nfactory = new NameFactory();
        String sFirstName, sLastName;
        Namer namer;

        //send the text to the factory and get a class back
        namer = nfactory.getNamer("Hello, World");
        //comute the first and last names using the returned class
        sFirstName = namer.getFirst();
        sLastName = namer.getLast();

        System.out.println(sFirstName + " " + sLastName); //World Hello
    }
}

