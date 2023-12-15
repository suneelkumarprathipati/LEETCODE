class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> cities = new HashSet<String>();
        for ( List<String> path : paths ){
            cities.add(path.get(0));
        }
        for ( List<String> path : paths ){
            String des = path.get(1);
            if ( !cities.contains(des))
                return des;
        }
        return "";
    }
}