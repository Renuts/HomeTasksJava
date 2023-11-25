
public class Cat extends Animal {
    public Cat(String name) {
        super("Кот", name, 200, 0);
    }

    @Override
    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(type + " " + name + " пробежал " + distance + " м");
        } else {
            System.out.println(type + " " + name + " не может пробежать " + distance + " м");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(type + " " + name + " не умеет плавать");
    }
}
