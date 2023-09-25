package SDE.ArraysII;

import java.util.ArrayList;
import java.util.List;

public class DesignHashMap {


        List<Pair>[] ds;
    
    
        public DesignHashMap() {
            ds = new List[50];
            for(int i=0;i<ds.length;i++){
                ds[i] = new ArrayList<>();
            }
        }
        
        public void put(int key, int value) {
            //hash the key
            int index = key%50;
            
            //get the list block from the ds
            List<Pair> ds_block = ds[index];
    
            boolean keypresent=false;
            for(int i=0;i<ds_block.size();i++){
                Pair pair = ds_block.get(i);
                if(pair.getKey() == key){
                    pair.setVal(value);
                    keypresent=true;
                    break;
                }
            }
            if(!keypresent){
                ds_block.add(new Pair(key,value));
            }
        }
        
    
        public int get(int key) {
            //hash th ekey to get index
            int index=key%50;
            
            // get the block
            List<Pair> ds_block = ds[index];
            for(int i=0;i<ds_block.size();i++){
                Pair pair = ds_block.get(i);
                if(pair.getKey()==key){
                    return pair.getVal();
                }
            }
            return -1;
        }
        
        public void remove(int key) {
            //hash th ekey to get index
            int index=key%50;
            
            // get the block
            List<Pair> ds_block = ds[index];
            for(int i=0;i<ds_block.size();i++){
                Pair pair = ds_block.get(i);
                if(pair.getKey()==key){
                    ds_block.remove(i);
                }
            }
        }
    
    
    
    class Pair{
        int key;
        int val;
    
        Pair(int k, int v){
            key = k;
            val =v;
        }
    
        int getKey(){
            return key;
        }
    
        int getVal(){
            return val;
        }
    
        void setVal(int v){
            val=v;
        }
    }
    
}
