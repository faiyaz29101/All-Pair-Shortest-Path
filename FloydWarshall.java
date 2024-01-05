public class FloydWarshall {
    private int[][] mat = null;
    private StringBuffer sb = new StringBuffer();
    public FloydWarshall(int [][] t, int v) {
        mat = t;
        int vertices = v;
        sb.append("Result using Floyd-Warshall algorithm:\n");
//        for(int i = 0; i<vertices; i++){
//            for(int j = 0; j< vertices; j++){
//                System.out.print(mat[i][j] + " ");
//            }
//            System.out.println();
//        }
        for (int p = 0; p < vertices; p++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    mat[i][j] = findmin(mat[i][j], (mat[i][p] + mat[p][j]));
                }
            }
        }
        for(int i = 0; i<vertices; i++){
            for(int j = 0; j< vertices; j++){
                if(mat[i][j] !=  100000) {
                    sb.append(mat[i][j] + " ");
                }else{
                    sb.append("INF ");
                }
            }
            sb.append("\n");
        }
        //System.out.println(sb);
    }

    public String getString() {
        return sb.toString();
    }

    private int findmin(int a, int b){
        if(a>b){
            return b;
        }
        return a;
    }
}
