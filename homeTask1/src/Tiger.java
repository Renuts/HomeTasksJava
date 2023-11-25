
public class Tiger extends Animal {
    public Tiger(String name) {
        super("Тигр", name, 350, 5);
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
