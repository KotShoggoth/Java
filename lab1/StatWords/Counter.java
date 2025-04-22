package StatWords;

public class Counter {
    int counter;

    Counter(int numb){
        counter=numb;
    }

    public void add(){
        counter++;
    }

    public int getCounter(){
        return counter;
    }
}
