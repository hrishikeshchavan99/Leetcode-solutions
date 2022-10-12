class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int col = image[0].length;
        if (image[sr][sc] == color)
            return image;
        else{
            int scolor = image[sr][sc];
            image[sr][sc] = color;
            if (sr-1 >= 0 && image[sr-1][sc] == scolor) floodFill(image, sr-1, sc, color);
            if (sr+1 < row && image[sr+1][sc] == scolor) floodFill(image, sr+1, sc,  color);
            if (sc-1 >= 0 && image[sr][sc-1] == scolor) floodFill(image, sr, sc-1, color);
            if (sc+1 < col && image[sr][sc+1] == scolor) floodFill(image, sr, sc+1, color);
            return image;
        }
    }
}