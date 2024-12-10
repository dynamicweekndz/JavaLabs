package box;

// Обобщенная коробка
public class Box<T> {
    private T item;

    // Метод для помещения объекта в коробку
    public void put(T item) {
        if (this.item != null) {
            throw new IllegalStateException("Коробка уже заполнена!");
        }
        this.item = item;
    }

    // Метод для извлечения объекта из коробки
    public T get() {
        T temp = this.item;
        this.item = null; // Обнуляем ссылку на объект
        return temp;
    }

    // Проверка на заполненность коробки
    public boolean isFull() {
        return this.item != null;
    }

    @Override
    public String toString() {
        return "Box{" +
                "item=" + (item != null ? item.toString() : "пустая") +
                '}';
    }
}
