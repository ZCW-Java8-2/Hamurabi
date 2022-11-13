package hammurabi.docs.matuszek;//package Hammurabi;
import java.util.Random;         // imports go here
import java.util.Scanner;

import hammurabi.docs.matuszek.Hammurabi;
import hammurabi.docs.matuszek.normalEvents.*;
import hammurabi.docs.matuszek.disasterEvents.*;;

public class gameStart {
    public static void main(String[] args) { // required in every Java program

        new Hammurabi(100, 2800, 1000, 19).playGame();

    }
}
