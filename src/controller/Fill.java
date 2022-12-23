/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package controller;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Fill {
    static String[] names ={
            "James", "John", "Robert", "Michael", "William", "David", "Richard", "Charles", "Joseph", "Thomas", "Christopher", "Daniel", "Paul", "Mark", "Donald", "George", "Kenneth", "Steven", "Edward", "Brian", "Ronald", "Anthony", "Kevin", "Jason", "Matthew", "Gary", "Timothy", "Jose", "Larry", "Jeffrey", "Frank", "Scott", "Eric", "Stephen", "Andrew", "Raymond", "Gregory", "Joshua", "Jerry", "Dennis", "Walter", "Patrick", "Peter", "Harold", "Douglas", "Henry", "Carl", "Arthur", "Ryan", "Roger", "Joe", "Juan", "Jack", "Albert", "Jonathan", "Justin", "Terry", "Gerald", "Keith", "Samuel", "Willie", "Ralph", "Lawrence", "Nicholas", "Roy", "Benjamin", "Bruce", "Brandon", "Adam", "Harry", "Fred", "Wayne", "Billy", "Steve", "Louis", "Jeremy", "Aaron", "Randy", "Howard", "Eugene", "Carlos", "Russell", "Bobby", "Victor", "Martin", "Ernest", "Phillip", "Todd", "Jesse", "Craig", "Alan", "Shawn", "Clarence", "Sean", "Philip", "Chris", "Johnny", "Earl", "Jimmy", "Antonio","Mary", "Patricia", "Linda", "Barbara", "Elizabeth", "Jennifer", "Maria", "Susan", "Margaret", "Dorothy", "Lisa", "Nancy", "Karen", "Betty", "Helen", "Sandra", "Donna", "Carol", "Ruth", "Sharon", "Michelle", "Laura", "Sarah", "Kimberly", "Deborah", "Jessica", "Shirley", "Cynthia", "Angela", "Melissa", "Brenda", "Amy", "Anna", "Rebecca", "Virginia", "Kathleen", "Pamela", "Martha", "Debra", "Amanda", "Stephanie", "Carolyn", "Christine", "Marie", "Janet", "Catherine", "Frances", "Ann", "Joyce", "Diane", "Alice", "Julie", "Heather", "Teresa", "Doris", "Gloria", "Evelyn", "Jean", "Cheryl", "Mildred", "Katherine", "Joan", "Ashley", "Judith", "Rose", "Janice", "Kelly", "Nicole", "Judy", "Christina", "Kathy", "Theresa", "Beverly", "Denise", "Tammy", "Irene", "Jane", "Lori", "Rachel", "Marilyn", "Andrea", "Kathryn", "Louise", "Sara", "Anne", "Jacqueline", "Wanda", "Bonnie", "Julia", "Ruby", "Loïs","Reve"
    };

    // string list with last name
    static String[] lastnames={
            "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen", "Young", "Hernandez", "King", "Wright", "Lopez", "Hill", "Scott", "Green", "Adams", "Baker", "Gonzalez", "Nelson", "Carter", "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Campbell", "Parker", "Evans", "Edwards", "Collins", "Stewart", "Sanchez", "Morris", "Rogers", "Reed", "Cook", "Morgan", "Bell", "Murphy", "Bailey", "Rivera", "Cooper", "Richardson", "Cox", "Howard", "Ward", "Torres", "Peterson", "Gray", "Ramirez", "James", "Watson", "Brooks", "Kelly", "Sanders", "Price", "Bennett", "Wood", "Barnes", "Ross", "Henderson", "Coleman", "Jenkins", "Perry", "Powell", "Long", "Patterson", "Hughes", "Flores", "Washington", "Butler", "Simmons", "Foster", "Gonzales", "Bryant", "Alexander", "Russell", "Griffin", "Diaz", "Hayes", "Myers", "Ford", "Hamilton", "Graham", "Sullivan", "Wallace", "Woods", "Cole", "West", "Jordan", "Owens", "Reynolds", "Fisher", "Ellis", "Harrison", "Gibson", "Mcdonald", "Cruz", "Marshall", "Ortiz", "Gomez", "Murray", "Freeman", "Wells", "Webb", "Simpson", "Stevens", "Tucker", "Porter", "Hunter", "Hicks",
    };

    public static int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100};

    public static int[] days ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28};

    public static int[] months={1,2,3,4,5,6,7,8,9,10,11,12};

    static String[] street={
            "Avenue","Boulevard","Chemin","Impasse","Place","Rue","Square","Voie","Allée","Esplanade","Route","Quai"
    };

    static String[] name_street={
            "Victor Hugo","de L Eglise","du Stade","Pasteur","des Jardins","des Îles","de la Gare","de la Mairie","du Moulin","de la Fontaine","des Lilas","des Tulipes"
    };

    static String[] ville_and_ZIP_code={
            "Paris 75000","Marseille 13000","Lyon 69000","Toulouse 31000","Nice 06000","Nantes 44000","Strasbourg 67000","Montpellier 34000","Bordeaux 33000","Lille 59000","Rennes 35000","Reims 51000","Le Havre 76000","Saint-Étienne 42000","Toulon 83000","Grenoble 38000","Dijon 21000","Angers 49000","Nîmes 30000","Villeurbanne 69100","Le Mans 72000","Aix-en-Provence 13090","Brest 29200","Tours 37000","Limoges 87000","Saint-Denis 93200","Perpignan 66000","Besançon 25000","Orléans 45000","Metz 57000","Rouen 76000","Mulhouse 68000","Caen 14000","Nancy 54000","Argenteuil 95100","Roubaix 59100","Tourcoing 59200","Montreuil 93100","Avignon 84000","Clermont-Ferrand 63000","Boulogne-Billancourt 92100","Amiens 80000","Aulnay-sous-Bois 93600","Rueil-Malmaison 92500","Saint-Denis 93200","Poitiers 86000","Versailles 78000","Montpellier 34000","Nanterre 92000","Asnières-sur-Seine 92600","Courbevoie 92400","Colombes 92700","Vitry-sur-Seine 94400","Antibes 06600","La Rochelle 17000","Saint-Paul 97400","Saint-Pierre 97400","Saint-Benoît 97400","Saint-Denis 97400","Sainte-Suzanne 97400","Sainte-Marie 97400","Sainte-Rose 97400","Sainte-Anne 97400","Sainte-Luce 97400","Sainte-Clotilde 97400","Sainte-Suzanne 97400","Sainte-Rose 97400","Sainte-Marie 97400","Sainte-Luce 97400"
    };

    String[] date=new String[1460];

    //String[] d'objets
    static String[] products={
            "Ordinateur","Bouquet de Fleurs","Livre","Mouchoir","Film/DVD","Musique/CD","Jeux-vidéo","Jouet","Puzzle","Pomme","Poire","Casque Audio","Smartphone","Manette de jeux","Lecteur MP3","Ipad","Ipod","Parfum","Bijoux","Maquillage"
    };

    static String[] status={
            "Pending","Transmitted"
    };

    private static String randomDate() {
        //take a random day in int[] days
        int day = days[(int) (Math.random() * days.length)];
        //take a random month in int[] months
        int month = months[(int) (Math.random() * months.length)];
        //take a year between 2017 and 2022
        int year = (int) (Math.random() * (2022 - 2017)) + 2017;

        return year + "-" + month + "-" + day;
    }
    private static String randomAdress(){
        int street_number=numbers[(int) (Math.random() * numbers.length)];
        //take a random street in String[] street
        String street_name=street[(int) (Math.random() * street.length)];
        //take a random name_street in String[] name_street
        String name_street_name=name_street[(int) (Math.random() * name_street.length)];
        //take a random ville_and_ZIP_code in String[] ville_and_ZIP_code
        String ville_and_ZIP_code_name=ville_and_ZIP_code[(int) (Math.random() * ville_and_ZIP_code.length)];

        return street_number+" "+street_name+" "+name_street_name+" ,"+ville_and_ZIP_code_name;
    }

    private static String randomHuman(){
        //take a random name in String[] name
        String name=names[(int) (Math.random() * names.length)];
        String lastname=lastnames[(int) (Math.random() * lastnames.length)];
        return name+" "+lastname;
    }

    private static String randomProduct(){
        //take a random product in String[] products
        String product=products[(int) (Math.random() * products.length)];
        return product;
    }
    private static String randomStatus(){
        //take a random status in String[] status
        String statu=status[(int) (Math.random() * status.length)];
        return statu;
    }
    private static String quantity(){
        //take a random quantity between 1 and 10
        int quantity = numbers[(int) (Math.random() * numbers.length)];
        return String.valueOf(quantity);
    }

    private static String price(){
        //take a random price between 1 and 100
        int dollars = numbers[(int) (Math.random() * numbers.length)]*3;
        int cents = numbers[(int) (Math.random() * numbers.length)];
        double price = dollars + (cents / 100.0);
        return String.valueOf(price);
    }
    public static void main(String[] args) {

        for(int i=0;i<2000;i++){
            System.out.printf("INSERT INTO garage_michel (customerName, customerAddress, sellerName, sellerAdress, product, quantity, price, dateSale, dateExpiry, statusInvoice) VALUES " +
                    "('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');\n",randomHuman(),randomAdress(),randomHuman(),randomAdress(),randomProduct(),quantity(),price(),randomDate(),randomDate(),randomStatus());
        }
    }
}
