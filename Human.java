
class Human {

    String name;
    int age;

    void move() {
        System.out.println("Human can move");
    }

    void eat() {
        System.out.println("Human can eat");
    }
}

class Boy extends Human {

    Boy(String n, int a) {
        name = n;
        age = a;
    }

    void play() {
        System.out.println(name + " is playing");
    }
}

class Girl extends Human {

    Girl(String n, int a) {
        name = n;
        age = a;
    }

    void cook() {
        System.out.println(name + " is cooking");
    }

}

class MyClass {

    void display() {
        Boy b = new Boy("Rahim", 15);
        Girl g = new Girl("Karima", 14);
        b.play();
        g.cook();
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.display();
    }
}
