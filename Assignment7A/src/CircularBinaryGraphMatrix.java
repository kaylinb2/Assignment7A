public class CircularBinaryGraphMatrix {

    public static void main(String[] args) {
        String input = "ANT CUN BOG AMA DC TOL SAN";
        String[] nodes = input.split(" ");
        int n = nodes.length;

        int[][] matrix = new int[n][n];

        // Fill matrix based on circular binary edges
        for (int i = 0; i < n; i++) {
            int right = (2 * i +1) % n;
            int left = (2 * i +2) % n;
            matrix[i][right] = 1;
            matrix[i][left] = 1;
        }

        // Print header row
        System.out.print("   ");
        for (String node : nodes) {
            System.out.printf("%4s", node);
        }
        System.out.println();

        // Print matrix
        for (int i = 0; i < n; i++) {
            System.out.printf("%4s |", nodes[i]);
            for (int j = 0; j< n; j++) {
                System.out.printf("%4s ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
