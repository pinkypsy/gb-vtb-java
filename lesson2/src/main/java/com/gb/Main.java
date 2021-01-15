package com.gb;

import javafx.scene.control.Alert;

public class Main {
    class Inner {
        int innerValue;

        public Inner(int innerValue) {
            this.innerValue = innerValue;
        }

        public void innerMethod() {
            System.out.println(innerValue);
            System.out.println(outerValue);
            outerMethod();
        }
    }

        int outerValue;

        public void outerMethod(){
            System.out.println(outerValue);
//            System.out.println(innerValue); //no access
//            innerMethod(); //no access
            Inner inner = new Inner(10);
        }

    public static void main(String[] args) {

    }
}
