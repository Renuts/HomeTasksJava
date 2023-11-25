
public class Dog extends Animal {
    public Dog(String name) {
        super("Пёс", name, 500, 10);
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
        if (distance <= swimLimit) {
            System.out.println(type + " " + name + " проплыл " + distance + " м");
        } else {
            System.out.println(type + " " + name + " не может проплыть " + distance + " м");
        }
    }
}
