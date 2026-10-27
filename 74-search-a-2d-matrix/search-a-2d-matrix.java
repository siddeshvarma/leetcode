class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0;
        int high=matrix.length-1;
        int row=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target>=matrix[mid][0] && target<=matrix[mid][matrix[0].length-1]){     
                row=mid;
                break;
            }
            else if(target>matrix[mid][matrix[0].length-1]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        if(row==-1)return false;
        int i=row;
        low=0;
        high=matrix[0].length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(matrix[i][mid]==target){
                return true;
            }
            else if(matrix[i][mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }return false;
    }
}