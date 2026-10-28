class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0;i<image.length;i++){
            for(int k=0;k<image[i].length;k++){
                if(image[i][k]==0)image[i][k]=1;
                else image[i][k]=0;
            }
            for(int j=0;j<image[i].length/2;j++){
                int temp=image[i][j];
                image[i][j]=image[i][image[i].length-j-1];
                image[i][image[i].length-j-1]=temp;
            }
        }
        return image;
    }
}