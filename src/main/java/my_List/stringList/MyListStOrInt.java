package my_List.stringList;

public interface MyListStOrInt<T> {


     T add(T item);


    T add(int index, T item);


    T set(int index, T item);


    T remove(T item);


    T remove(int index);


    // Проверка на существование элемента.
    // Вернуть true/false;
    boolean contains(T item);

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    int indexOf(T item);

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    int lastIndexOf(T item);

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    T get(int index);

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    boolean equals(MyListStOrInt otherList);

    // Вернуть фактическое количество элементов.
    int size();

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    boolean isEmpty();

    // Удалить все элементы из списка.
    void clear();

    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    T[] toArray();

    T[] getStringsArray();
}

