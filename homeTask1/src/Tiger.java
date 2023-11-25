
public class Tiger extends Animal {
    public Tiger(String name) {
        super("����", name, 350, 5);
    }

    @Override
    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(type + " " + name + " �������� " + distance + " �");
        } else {
            System.out.println(type + " " + name + " �� ����� ��������� " + distance + " �");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= swimLimit) {
            System.out.println(type + " " + name + " ������� " + distance + " �");
        } else {
            System.out.println(type + " " + name + " �� ����� �������� " + distance + " �");
        }
    }
}
