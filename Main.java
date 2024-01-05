import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String OUTPUT_FILE1_NAME = "output.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE1_NAME));
        String line = br.readLine();
        String[] nums = line.split(" ");
        int vertices = Integer.parseInt(nums[0]);
        int edges = Integer.parseInt(nums[1]);
        int[][] mat = new int[vertices][vertices];
        int INF =  100000;
        for(int i = 0; i<vertices; i++){
            for(int j = 0; j< vertices; j++){
                mat[i][j] = INF;
                if(i == j){
                    mat[i][j] = 0;
                }
            }
        }
        for(int i=0; i< edges; i++){
            line = br.readLine();
            nums = line.split(" ");
            mat[Integer.parseInt(nums[0])-1][Integer.parseInt(nums[1])-1] = Integer.parseInt(nums[2]);
        }
//        for(int i = 0; i<vertices; i++){
//            for(int j = 0; j< vertices; j++){
//               // System.out.print(mat[i][j] + " ");
//            }
//           //System.out.println();
//        }
        FloydWarshall f = new FloydWarshall(mat, vertices);
        bw.write(f.getString()+"\n");
        MatrixMultiplication m = new MatrixMultiplication(mat, vertices);
        bw.write(m.getString());
        bw.close();

    }

}