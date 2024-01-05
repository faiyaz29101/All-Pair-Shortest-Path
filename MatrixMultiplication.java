import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MatrixMultiplication {
    private int[][] mat = null;
    private StringBuffer sb = new StringBuffer();
    public MatrixMultiplication(int [][] t, int v) {
        mat = t;
        int vertices = v;
        sb.append("Result using Matrix Multiplication:\n");
        int[][] temp = new int[vertices][vertices];
        for(int i =0; i< vertices; i++){
            for(int j = 0; j<vertices; j++){
                List<Integer> l = new ArrayList<Integer>();
                for(int k = 0; k<vertices; k++){
                    l.add(mat[i][k] + mat[k][j]);
                }
                temp[i][j] = Collections.min(l);
            }
        }
        for(int i =0; i< vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if(temp[i][j] < 100000) {
                    sb.append(temp[i][j] + " ");
                }else {
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

}
