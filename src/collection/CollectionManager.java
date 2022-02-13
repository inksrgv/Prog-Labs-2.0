package collection;

import java.util.ArrayDeque;

/**
 * @param <T> тип элементов
 */

public interface CollectionManager<T> {
    /**
     * генератор айди
     * @return
     */
    public int IdGenerator();

    public void sort();

    public ArrayDeque<T> getCollection();

    /**
     * добавляет элемент
     * @param element
     */
    public void add(T element);

    /**
     * @return info
     */
    public String getInfo();

    /**
     * проверяет если в коллекции элемент с заданным айди
     * @param ID
     * @return
     */
    public boolean checkId(Integer ID);

    /**
     * удаляет по айди
     * @param id
     */
    public void removeById(Integer id);

    /**
     *
     * @param id
     * @param newElement
     */
    public void updateById(Integer id, T newElement);

    public void clear();

    public void removeFirst();

    /**
     *
     * @param element
     */
    public void addIfMin(T element);

    public void startsWithName(String start);

    /**
     * вывод всех значений расстояния
     */
    public void printDistance();


}