import java.util.HashMap;
import java.util.ArrayList;

/**
 * hashmap
 *********** I PROBABLY SHOULD'VE USED DOUBLE INSTEAD OF FLOAT BUT ITS TOO LATE ************
 */

public class App {

    // Arbitrary Keyword Argument Function for creating fast lists
    static ArrayList<Float> createFloatArrayList (Float ... listOfFloats) {
        ArrayList<Float> theFloatList = new ArrayList<Float>();
        for (float i: listOfFloats) {
            theFloatList.add(i);
        }
        return theFloatList;
    }


    // ArrayList of Strings using Arbitrary Argument
    static ArrayList<String> createStringArrayList (String ... listOfNames) {

        ArrayList<String> namesList = new ArrayList<String>();
        for (String name: listOfNames) {
            namesList.add(name);
        }
        return namesList;
    }

//    // Method currently unused. Ignore.
//    static void /**HashMap<ArrayList, String>**/ testMethod (ArrayList<String> names, HashMap<String, Float> test9) {
//        for (String i : test9.keySet()) {
//            System.out.println(i);
//            ArrayList<String> test1 = new ArrayList<String>();
//            HashMap<ArrayList, String> test2 = new HashMap<ArrayList, String>();
//            String test10 = 0;
//            test1.add(test9, test10);
//            //return test1;
//        }
//    }


    // Method for creation of dots.
    static ArrayList<String> createDots (HashMap<String, Float> aHashMap) {
        ArrayList<String> listOfItemsWithDots = new ArrayList<String>();
        for (String i : aHashMap.keySet()) {
            Integer dots = 30;
            dots = dots - i.length();
            ArrayList<String> dotsList = new ArrayList<String>();
            for (int x = 0; x < dots; x++) {
                dotsList.add(".");
            }

            // Joins the list of dots into a string.
            String listString = "";

            for (String s : dotsList) {
                listString += s + "";
            }

            listOfItemsWithDots.add(i + listString + "$" + aHashMap.get(i) + "0");
        }
        return listOfItemsWithDots;
    }

    // Dots, but intead of an ArrayList, it does it for a singular string.
    static String createDotsString (String theWord, Float price) {
        Integer dots = 30;
        dots = dots - theWord.length();
        ArrayList<String> dotsList = new ArrayList<String>();

        for (int x = 0; x < dots; x++) {
            dotsList.add(".");
        }

        // Joins the list of dots into a string.
        String listString = "";
        for (String s : dotsList) {
            listString += s + "";
        }
        
        String text = (theWord + listString + "$" + price + "0");
        return text;
        
    }

    static void printStringArrayList (ArrayList<String> listOfItemsToPrint) {
        for (String name: listOfItemsToPrint) {
            System.out.println(name);
        }
    }

    public static void main(String[] arg) {
        //System.out.println(test("lol"));
        HashMap<String, Float> foodMenu = new HashMap<String, Float>();

        //Makes New Lists with the Floats and Names on identical indexes, then iterates through and adds it to the HashMap, foodMenu.
        ArrayList<Float> foodMenuPrices = createFloatArrayList(4.50f, 4.00f, 6.50f, 7.00f, 7.00f, 6.50f, 3.70f);
        ArrayList<String> foodMenuNames = createStringArrayList("Chicken Salad", "Vegan Salad", "Hamburger", "Chicken Burger", "Mushroom Burger", "Salad Burger", "Shortcake");
        for (int num = 0; num < foodMenuPrices.size(); num++) {
            foodMenu.put(foodMenuNames.get(num), foodMenuPrices.get(num));
        }

        HashMap<String, Float> drinksMenu = new HashMap<String, Float>();


        // Doing it but for the drinks now.
        ArrayList<Float> drinkMenuPrices = createFloatArrayList(0.00f, 2.50f, 2.70f, 1.00f, 1.00f, 2.00f);
        ArrayList<String> drinkMenuNames = createStringArrayList("Water", "Orange Juice", "Cranberry Juice", "Soft Drink", "Coffee", "Tea");
        for (int num1 = 0; num1 < drinkMenuPrices.size(); num1++) {
            drinksMenu.put(drinkMenuNames.get(num1), drinkMenuPrices.get(num1));
        }


        HashMap<String, ArrayList<String>> combosMenu = new HashMap<String, ArrayList<String>>();

        // THE DOTS
        System.out.println("-=-=-=-=-=-= Food Menu =-=-=-=-=-=-");
        printStringArrayList(createDots(foodMenu));
        System.out.println("\n");

        System.out.println("-=-=-=-=-=-= Drinks Menu =-=-=-=-=-=-");
        printStringArrayList(createDots(drinksMenu));
        System.out.println("\n");

        combosMenu.put("Chicken Salad Combo", createStringArrayList("Chicken Salad", "Orange Juice"));
        combosMenu.put("Vegan Salad Combo", createStringArrayList("Vegan Salad", "Orange Juice"));
        combosMenu.put("Hamburger Combo", createStringArrayList("Hamburger", "Soft Drink"));
        combosMenu.put("Chicken Burger Salad", createStringArrayList("Chicken Burger", "Soft Drink"));
        combosMenu.put("Mushroom Burger Combo", createStringArrayList("Mushroom Burger", "Cranberry Juice"));
        combosMenu.put("Big Meal Combo", createStringArrayList("Chicken Burger", "Vegan Salad", "Soft Drink"));
        combosMenu.put("Vegan Brunch Combo", createStringArrayList("Salad Burger", "Coffee"));
        combosMenu.put("High Tea Combo", createStringArrayList("Shortcake", "Tea"));

        System.out.println("-=-=-=-=-=-= Combo Menu =-=-=-=-=-=-");
        for (String combo: combosMenu.keySet()) {
            
            System.out.println(combo + "\n");
            Float price = 0.00f;
            for (String item: combosMenu.get(combo)) {
                
                for (String food: foodMenu.keySet()) {
                    if (item == food) {
                        price += foodMenu.get(food);
                        System.out.println("\t" + createDotsString(food, (foodMenu.get(food))));
                    }
                }
                for (String drink: drinksMenu.keySet()) {
                    if (item == drink) {
                        price += drinksMenu.get(drink);
                        System.out.println("\t" + createDotsString(drink, (drinksMenu.get(drink))));
                    }
                }
            
            }
            System.out.println("\n" + "\t" + createDotsString("Total of Combo", price) + "\n");
        }
    }
}