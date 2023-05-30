class MyHashSet {
    private List<Integer>[] bucket;
    private int capacity;
    private double loadfactor;
    private int count = 0;

    //initializing DS here 

    public MyHashSet() {
        capacity = 1000;
        loadfactor = 0.75;
        bucket = new LinkedList[capacity]; 
        
    }
    
    public void add(int key) {
        if (contains (key))
        return;
        if (loadfactor * capacity == count){
            count =0;
            capacity *=2;
            List<Integer>[]oldBucket = bucket;
            bucket = new LinkedList[capacity];
            for(int i=0; i < oldBucket.length; i++){
                List<Integer> list  = oldBucket[i];
                if (list !=null){
                    for (int entry : list)
                     this.add(entry);
                }
            }

        }
        int hash = key % capacity;
        if (bucket[hash] == null)
           bucket [hash] = new LinkedList<>();
           bucket[hash].add(key);
           ++count;
        
    }
    
    public void remove(int key) {
        int hash = key % capacity ;
        List<Integer> list = bucket[hash];
        if(list != null){
            Iterator<Integer> iterator = list.iterator();
            while(iterator.hasNext()) {
                if (iterator.next() == key){
                    iterator.remove();
                    --count;
                }
            }
        }
        
    }
    
    public boolean contains(int key) {
        int hash = key % capacity;
        List<Integer> list = bucket[hash];
        if (list != null){
            for (int k : list )
               if (k == key )
                  return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */