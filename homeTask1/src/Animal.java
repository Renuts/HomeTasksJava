
public abstract class Animal {
    protected String name;
    protected int runLimit;
    protected int swimLimit;
    protected String type;

    public Animal(String type, String name, int runLimit, int swimLimit) {
        this.type = type;
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);
}
