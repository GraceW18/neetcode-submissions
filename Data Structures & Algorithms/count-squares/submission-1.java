class CountSquares {
    private List<List<Integer>> points;
    private Map<List<Integer>, Integer> count; // num times a point appears (coordinates)

    public CountSquares() {
        points = new ArrayList<>();
        count = new HashMap<>();
    }
    
    public void add(int[] point) {
        List<Integer> p = Arrays.asList(point[0], point[1]);
        if (!count.containsKey(p)) {
            points.add(p);
        }
        count.put(p, count.getOrDefault(p, 0) + 1);
    }
    
    public int count(int[] point) {
        int num = 0;
        int px = point[0];
        int py = point[1];
        for (List<Integer> p : points) {
            int x = p.get(0);
            int y = p.get(1);
            if (Math.abs(px - x) != Math.abs(py - y) || x == px || y == py) {
                continue; // skip because can't form valid square
            }
            num += count.getOrDefault(Arrays.asList(px, y), 0) *
            count.getOrDefault(Arrays.asList(x, py), 0) *
            count.getOrDefault(p, 0);
        }
        return num;
    }
}
