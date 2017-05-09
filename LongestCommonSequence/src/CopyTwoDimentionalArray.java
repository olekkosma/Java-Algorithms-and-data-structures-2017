
class CopyTwoDimentionalArray {

    public static void copyArray(int[][] array1, int[][] array2, int width, int height) {
        int i, j;
        for (i = 0; i < width; i++) {

            for (j = 0; j < height; j++) {

                array2[i][j] = array1[i][j];
            }
        }

    }

}
