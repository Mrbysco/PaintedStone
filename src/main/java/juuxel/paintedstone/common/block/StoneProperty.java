package juuxel.paintedstone.common.block;

public final class StoneProperty<T>
{
    private final String name;
    private final T value;

    private StoneProperty(String name, T value)
    {
        this.name = name;
        this.value = value;
    }

    public String getName()
    {
        return name;
    }

    public T getValue()
    {
        return value;
    }

    public static <T> StoneProperty<T> get(String name, T value)
    {
        return new StoneProperty<T>(name, value);
    }
}
