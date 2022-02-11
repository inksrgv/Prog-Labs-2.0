package utils.loc;

import utils.Validateable;

public class Location implements Validateable {
    private int x;
    private float y;
    private String name; //Поле может быть null
    public Location(int x, float y){
        this.x = x;
        this.y = y;
    }
    /**
     * @return x coordinates
     */
    public int getX() {
        return x;
    }

    /**
     * @return y coordinates
     */
    public float getY() {
        return y;
    }
    @Override
    public String toString(){
        String s = "";
        s += "{\"x\" : " + Int.toString(x) + ", "; //Почему ошибка
        s += "\"y\" : " + Float.toString(y) + "}";
        return s;
    }
    public boolean validate(){
        return !(); //Прописать условие с нулевым полем
    }
}

