package utils;

/**
 * interface for storable object
 */
public interface Collectionable extends Comparable<Collectionable>, Validateable{

    public int getId();
    /**
     * sets id, useful for replacing object in collection
     * @param ID
     */
    public void setId(int ID);

    public long getSalary();

    public String getName();

    /**
     * compairs two objects
     */
    public int compareTo(Collectionable route);
    public boolean validate();
}
