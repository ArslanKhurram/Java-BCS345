public abstract class Person implements myLsnr{

    protected String name;
    public abstract void setName();

    @Override
    public String toString() {
        return "This is the person class";
    }
}
