package nl.fampennings.keyboard;

import java.util.ArrayList;

/**
 * Created by ankur on 1/11/2017.
 */
public class value {
    ArrayList<ArrayList<Integer>> combiArray = new ArrayList<ArrayList<Integer>>();
 int i; int j; int k;

  public void  setArray (int i,int j,int k){
        this.i= i;
        this.j=j;
        this.k=k;
        ArrayList<Integer> innerArray = new ArrayList<Integer>();
        innerArray.add(i);
        innerArray.add(j);
        innerArray.add(k);
        combiArray.add(innerArray);
    }
   public  ArrayList<ArrayList<Integer>> getarraylist(){
       return combiArray;
   }
}
