package medium;
class CheapestFlightKStops{
    int[][] flightsToFrom;  
    int[][] mem;
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        flightsToFrom = new int[n][n];
        
        mem = new int[n][k+1];  
    
        for(int i=0; i<flights.length; i++){
                flightsToFrom[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        
        return dfs(src, dst, k);
    }
    
    
    int dfs(int src, int dest, int stop){
        
        if(src == dest){
            return 0;
        }
        
        if(stop < 0) {
            return -1;
        }
        
        if(mem[src][stop] != 0){
            return mem[src][stop];
        }
               
        int price = Integer.MAX_VALUE;

        for(int i=0; i<flightsToFrom.length; i++){
           if(flightsToFrom[src][i] == 0 || src == i ){
               continue;
           }else{   
               int p = dfs(i, dest, stop-1);
                     
               if(p == -1){
                   continue;
               }   
               price = Math.min(price, p + flightsToFrom[src][i]);
           }
        }
        
        if(price == Integer.MAX_VALUE){
            price = -1;
        }
        mem[src][stop] = price;
        
        return price;
    }
    
}