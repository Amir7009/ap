package ap.exercises.ex5.myObjectCounter;

import java.util.ArrayList;

public class MyObjectCounter {

    //private Map<String,Integer> counterMap;
    private ArrayList<String> urls;
    private ArrayList<Integer> urlCount;

    public MyObjectCounter() {
        //this.counterMap=new HashMap<>();
        this.urls = new ArrayList<>();
        this.urlCount = new ArrayList<>();
    }

    public void add(String item){
        if (this.urls.contains(item)){
            this.urlCount.set(this.urls.indexOf(item), this.urlCount.get(this.urls.indexOf(item))+1);
        }
        else{
            this.urls.add(item);
            this.urlCount.add(1);
        }
    }

    public String[][] getTop(int k){

        String[][] topUrls = new String[10][2];

        // bubble sort
        for (int i = 0 ; i < urlCount.size()-1 ; i++){

            for (int j = urlCount.size()-1 ; j > i ; j--){

                if(urlCount.get(j) > urlCount.get(j-1)){

                    String urlTemp = urls.get(j-1);
                    int countTemp = urlCount.get(j-1);

                    urls.set(j-1, urls.get(j));
                    urls.set(j, urlTemp);

                    urlCount.set(j-1, urlCount.get(j));
                    urlCount.set(j, countTemp);

                }

            }

        }

        // specify top k items
        for (int t = 0 ; t < k ; t++){

            topUrls[t][0] = urls.get(t);
            topUrls[t][1] = String.valueOf(urlCount.get(t));

        }

        return topUrls;

    }

}